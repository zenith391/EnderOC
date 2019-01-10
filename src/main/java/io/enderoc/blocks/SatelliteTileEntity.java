package io.enderoc.blocks;

import io.enderoc.OCranet;
import li.cil.oc.api.Network;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.Environment;
import li.cil.oc.api.network.Message;
import li.cil.oc.api.network.Node;
import li.cil.oc.api.network.Packet;
import li.cil.oc.api.network.SimpleComponent;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.TileEntityEnvironment;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class SatelliteTileEntity extends TileEntity implements Environment, ITickable {

	private Node node;
	
	public SatelliteTileEntity() {
		node = Network.newNode(this, Visibility.Network)
				.withConnector()
				.withComponent("universal_router")
				.create();
	}

	@Override
	public void onMessage(final Message message) {
		for (int i = 0; i < message.data().length; i++) {
			if (message.data()[i] instanceof Packet) {
				Packet pck = (Packet) message.data()[i];
				if (pck.destination() != null) { // Cannot broadcast over all of the internet
					Packet hop = pck.hop();
					if (hop.ttl() <= 0) {
						return;
					}
					OCranet.pendingPackets.push(hop);
				}
			}
		}
	}

	@Override
	public void update() {
		if (!world.isRemote) {
			if (OCranet.pendingPackets.size() > 0) {
				Packet packet = OCranet.pendingPackets.peek();
				if (packet.ttl() <= 0) {
					System.out.println("Deleting timed out packet..");
					OCranet.pendingPackets.remove(packet);
					return;
				}
				boolean v = false;
				for (Node n : node.reachableNodes()) {
					if (n.address().equals(packet.destination())) {
						v = true;
						break;
					}
				}
				if (!v) {
					return;
				}
				node.network().sendToReachable(node, "modem_message", packet.destination(), packet.source(), packet.port(), 400,
						packet.data());
				OCranet.pendingPackets.remove(packet);
			}

		}
	}

	@Override
	public Node node() {
		return node;
	}

	@Override
	public void onConnect(Node arg0) {
		
	}

	@Override
	public void onDisconnect(Node arg0) {
		
	}

}
