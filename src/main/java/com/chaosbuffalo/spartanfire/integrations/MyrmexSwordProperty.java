package com.chaosbuffalo.spartanfire.integrations;

import com.github.alexthe666.iceandfire.entity.EntityDeathWorm;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;


public class MyrmexSwordProperty extends WeaponPropertyWithCallback {

    public MyrmexSwordProperty(String propType, String propModId) {
        super(propType, propModId);
    }

    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if (target.getCreatureAttribute() != EnumCreatureAttribute.ARTHROPOD) {
            target.attackEntityFrom(DamageSource.GENERIC, 4);
        }
        if (target instanceof EntityDeathWorm) {
            target.attackEntityFrom(DamageSource.GENERIC, 4);
        }
    }
}
