package com.chaosbuffalo.spartanfire.integrations;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class FireDragonsteelWeaponProperty extends MeleeCallbackWeaponTrait {

    public FireDragonsteelWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target,
                            LivingEntity attacker, Entity projectile) {
        target.setSecondsOnFire(15);
        target.knockback(1F, attacker.position().x - target.position().x, attacker.position().z - target.position().z);
    }
}
