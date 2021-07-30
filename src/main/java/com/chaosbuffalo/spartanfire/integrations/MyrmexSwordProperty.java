package com.chaosbuffalo.spartanfire.integrations;

import com.github.alexthe666.iceandfire.entity.EntityDeathWorm;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;


public class MyrmexSwordProperty extends MeleeCallbackWeaponTrait {

    public MyrmexSwordProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public float modifyDamageDealt(WeaponMaterial material, float baseDamage, float initialDamage, DamageSource source, LivingEntity attacker, LivingEntity victim) {
        if (victim.getMobType() != CreatureAttribute.ARTHROPOD) {
            return baseDamage + 4;
        }
        if (victim instanceof EntityDeathWorm) {
            return baseDamage + 4;
        }
        return baseDamage;
    }
}
