package io.enderoc.init;

import java.util.List;

import io.enderoc.EnderOC;
import io.enderoc.blocks.SatelliteBlock;
import io.enderoc.handlers.RegistryEventHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlocksInit {

	public static SatelliteBlock satelliteBlock;
	
	public static void init() {
		EnderOC.logger.info("Initing blocks..");
		satelliteBlock = new SatelliteBlock();
		
		RegistryEventHandler.REGISTER_BLOCKS.add(satelliteBlock);
		RegistryEventHandler.REGISTER_ITEMS.add(new ItemBlock(satelliteBlock).setRegistryName(satelliteBlock.getRegistryName()).setUnlocalizedName("universal_router"));
	}
	
}
