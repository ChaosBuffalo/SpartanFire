package com.chaosbuffalo.spartanfire.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class SFItem extends Item {

    public SFItem(ResourceLocation registryName, ItemGroup tab){
        super(new Item.Properties().tab(tab));
        this.setRegistryName(registryName);
    }
}
