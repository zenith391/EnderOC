package io.enderoc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SatelliteBlock extends Block {

	public SatelliteBlock() {
		super(Material.IRON);
		setRegistryName("universal_router");
		setUnlocalizedName("universal_router");
		this.setCreativeTab(CreativeTabs.REDSTONE);
	}

	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	public TileEntity createTileEntity(World world, IBlockState state) {
		SatelliteTileEntity ste = new SatelliteTileEntity();
		ste.setWorld(world);
		return ste;
	}
	
}
