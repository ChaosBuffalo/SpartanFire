package com.chaosbuffalo.spartanfire.integrations;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTraitWithCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;


public class MyrmexPoisonSwordProperty extends WeaponTraitWithCallback {

    public MyrmexPoisonSwordProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
        target.addPotionEffect(new EffectInstance(Effects.POISON, 200, 2));
    }
}

