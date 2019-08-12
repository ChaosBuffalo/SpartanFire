package com.chaosbuffalo.spartanfire.integrations;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class FireDragonsteelWeaponProperty extends WeaponPropertyWithCallback {

    public FireDragonsteelWeaponProperty(String propType, String propModId) {
        super(propType, propModId);
    }

    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target,
                            EntityLivingBase attacker, Entity projectile) {
        target.setFire(15);
        target.knockBack(target, 1F, attacker.posX - target.posX, attacker.posZ - target.posZ);
    }
}
