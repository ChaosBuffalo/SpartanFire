package com.chaosbuffalo.spartanfire.integrations;

import com.github.alexthe666.iceandfire.entity.EntityDeathWorm;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyExtraDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;


public class MyrmexSwordProperty extends WeaponPropertyWithCallback {

    public MyrmexSwordProperty(String propType, String propModId) {
        super(propType, propModId);
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, float initialDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        if (victim.getCreatureAttribute() != EnumCreatureAttribute.ARTHROPOD) {
            return baseDamage + 4;
        }
        if (victim instanceof EntityDeathWorm) {
            return baseDamage + 4;
        }
        return baseDamage;
    }
}
