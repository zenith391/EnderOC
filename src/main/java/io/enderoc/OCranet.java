package io.enderoc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import li.cil.oc.api.network.Packet;

public class OCranet {

	public static Deque<Packet> pendingPackets = new ConcurrentLinkedDeque<>();
	
}
