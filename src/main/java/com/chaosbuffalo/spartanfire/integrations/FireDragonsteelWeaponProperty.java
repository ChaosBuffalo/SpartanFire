package com.chaosbuffalo.spartanfire.integrations;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public class FireDragonsteelWeaponProperty extends MeleeCallbackWeaponTrait {

    public FireDragonsteelWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target,
                            LivingEntity attacker, Entity projectile) {
        target.setFire(15);
        target.applyKnockback(1F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
    }
}
