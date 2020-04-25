package com.chaosbuffalo.spartanfire;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SpartanFire.MODID, name = SpartanFire.NAME, version = SpartanFire.VERSION,
        dependencies="required-after:iceandfire@[1.9.1,);required-after:spartanweaponry@[beta 1.3.0,);required-after:llibrary@[1.7.19,)")
public class SpartanFire
{
    public static final String MODID = "spartanfire";
    public static final String NAME = "Spartan Fire";
    public static final String VERSION = "@VERSION@";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
