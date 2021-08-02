package com.chaosbuffalo.spartanfire.integrations;

import com.github.alexthe666.citadel.server.entity.datatracker.EntityPropertiesHandler;
import com.github.alexthe666.iceandfire.entity.props.FrozenEntityProperties;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IceDragonsteelWeaponProperty extends MeleeCallbackWeaponTrait {

    public IceDragonsteelWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
        FrozenEntityProperties frozenProps = EntityPropertiesHandler.INSTANCE.getProperties(target, FrozenEntityProperties.class);
        frozenProps.setFrozenFor(300);
        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300, 2));
        target.applyKnockback(1F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
    }
}