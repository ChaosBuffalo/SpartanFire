package com.chaosbuffalo.spartanfire.integrations;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class LightningDragonsteelWeaponProperty extends MeleeCallbackWeaponTrait {

    public LightningDragonsteelWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target,
                            LivingEntity attacker, Entity projectile) {
        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 300, 2));
        target.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 13.5F);
        target.applyKnockback(1F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
    }
}
