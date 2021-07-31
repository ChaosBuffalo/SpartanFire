package com.chaosbuffalo.spartanfire;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SpartanFire.MODID)
public class SpartanFire
{
    public static final String MODID = "spartanfire";
    private static final Logger logger = LogManager.getLogger(MODID);
    private static SpartanFire instance;

    public SpartanFire() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        instance = this;
        MinecraftForge.EVENT_BUS.register(instance);
        bus.addListener(instance::commonSetup);
    }


    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event)
    {
        logger.info("SpartanFire: Common Setup");
    }

}
