package com.chaosbuffalo.spartanfire.integrations;

import com.github.alexthe666.iceandfire.entity.FrozenEntityProperties;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import net.ilexiconn.llibrary.server.entity.EntityPropertiesHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class IceDragonsteelWeaponProperty extends WeaponPropertyWithCallback {

    public IceDragonsteelWeaponProperty(String propType, String propModId) {
        super(propType, propModId);
    }

    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        FrozenEntityProperties frozenProps = EntityPropertiesHandler.INSTANCE.getProperties(target, FrozenEntityProperties.class);
        frozenProps.setFrozenFor(300);
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 2));
        target.knockBack(target, 1F, attacker.posX - target.posX, attacker.posZ - target.posZ);
    }
}