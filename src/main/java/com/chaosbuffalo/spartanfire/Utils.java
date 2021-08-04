package com.chaosbuffalo.spartanfire;

import com.github.alexthe666.citadel.server.item.CustomToolMaterial;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Jacob on 7/20/2018.
 */
public class Utils {

    public static WeaponMaterial spartanMatFromToolMat(String name, CustomToolMaterial material,
                                                       String matName, WeaponTrait... properties){
        return new WeaponMaterial(
                name,
                SpartanFire.MODID,
                9867904,
                14999238,
                material.getHarvestLevel(),
                material.getMaxUses(),
                material.getEfficiency(),
                material.getAttackDamage(),
                material.getEnchantability(),
                new ResourceLocation(IceAndFire.MODID, matName),
                properties
        );
    }

    public static WeaponMaterial spartanMatFromToolMat(String name, CustomToolMaterial material,
                                                       String matName){
        return new WeaponMaterial(
                name,
                SpartanFire.MODID,
                9867904,
                14999238,
                material.getHarvestLevel(),
                material.getMaxUses(),
                material.getEfficiency(),
                material.getAttackDamage(),
                material.getEnchantability(),
                new ResourceLocation(IceAndFire.MODID, matName)
        );
    }
}
