package com.chaosbuffalo.spartanfire;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Jacob on 7/20/2018.
 */
public class Utils {

    public static WeaponMaterial spartanMatFromToolMat(String name, IItemTier material,
                                                         int color1, int color2, String repairName){
        return new WeaponMaterial(
                name,
                repairName,
                SpartanFire.MODID,
                color1,
                color2,
                material.getHarvestLevel(),
                material.getMaxUses(),
                material.getEfficiency(),
                material.getAttackDamage(),
                material.getEnchantability());
    }

    public static ToolMaterialEx spartanMatFromToolMat(String name, Item.ToolMaterial material,
                                                       int color1, int color2){
        return new ToolMaterialEx(
                name,
                "ingot" + StringUtils.capitalize(name),
                SpartanFire.MODID,
                color1,
                color2,
                material.getHarvestLevel(),
                material.getMaxUses(),
                material.getEfficiency(),
                material.getAttackDamage(),
                material.getEnchantability());
    }
}
