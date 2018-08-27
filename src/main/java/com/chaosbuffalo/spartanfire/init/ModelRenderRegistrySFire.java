package com.chaosbuffalo.spartanfire.init;

import com.chaosbuffalo.spartanfire.SpartanFire;
import com.oblivioussp.spartanweaponry.util.LogHelper;
import com.oblivioussp.spartanweaponry.util.StringHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(modid = SpartanFire.MODID)
public class ModelRenderRegistrySFire {

    private static List<ModelRegistryEntry> models = new ArrayList();

    public ModelRenderRegistrySFire() {
    }

    @SubscribeEvent
    public static void registerItemRenders(ModelRegistryEvent ev) {
        Iterator var1 = models.iterator();
        while(var1.hasNext()) {
            ModelRegistryEntry entry = (ModelRegistryEntry)var1.next();
            registerItemRender(entry.getItem(), SpartanFire.MODID + ":" + entry.getModelLocation());
        }
        models.clear();
    }

    public static void addItemToRegistry(Item item, String modelLoc) {
        models.add(new ModelRegistryEntry(item, modelLoc));
    }


    public static void registerItemRender(Item item) {
        ModelResourceLocation modelLoc = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelLoc);
    }

    public static void registerItemRender(Item item, String modelName) {
        ModelResourceLocation modelLoc = new ModelResourceLocation(modelName, "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, modelLoc);
    }


    public static class ModelRegistryEntry {
        protected String modelLoc;
        protected Item item;

        public ModelRegistryEntry(Item itemForEntry, String modelLocation) {
            this.item = itemForEntry;
            this.modelLoc = modelLocation;
        }

        public Item getItem() {
            return this.item;
        }

        public String getModelLocation() {
            return this.modelLoc;
        }
    }
}


