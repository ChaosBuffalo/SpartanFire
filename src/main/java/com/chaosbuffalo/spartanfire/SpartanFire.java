package com.chaosbuffalo.spartanfire;

import com.github.alexthe666.iceandfire.core.ModItems;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;

@Mod(modid = SpartanFire.MODID, name = SpartanFire.NAME, version = SpartanFire.VERSION,
        dependencies="required-after:iceandfire;required-after:spartanweaponry@[beta 1.1.2]")
public class SpartanFire
{
    public static final String MODID = "spartanfire";
    public static final String NAME = "Spartan Fire";
    public static final String VERSION = "0.01";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        OreDictionary.registerOre("ingotDragonbone", ModItems.dragonbone);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
