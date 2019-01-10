package io.enderoc.proxy;

import io.enderoc.EnderOC;
import io.enderoc.blocks.SatelliteTileEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
		// Ignore by default
	}
	
	public void init(FMLInitializationEvent e) {
		GameRegistry.registerTileEntity(SatelliteTileEntity.class, new ResourceLocation(EnderOC.MODID, "satellite"));
	}
	
}
