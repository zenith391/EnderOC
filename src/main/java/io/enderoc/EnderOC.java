package io.enderoc;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;

import io.enderoc.proxy.CommonProxy;

@Mod(modid = EnderOC.MODID, name = EnderOC.NAME, version = EnderOC.VERSION)
public class EnderOC {
	
    public static final String MODID = "enderoc";
    public static final String NAME = "EnderOC";
    public static final String VERSION = "1.0";
    public static final String CLIENT_PROXY_CLASS = "io.enderoc.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "io.enderoc.proxy.CommonProxy";

    public static Logger logger;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    
}
