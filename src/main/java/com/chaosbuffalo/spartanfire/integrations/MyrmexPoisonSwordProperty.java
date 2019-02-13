package com.chaosbuffalo.spartanfire.integrations;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;


public class MyrmexPoisonSwordProperty extends WeaponPropertyWithCallback {

    public MyrmexPoisonSwordProperty(String propType, String propModId) {
        super(propType, propModId);
    }

    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        target.addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 2));
    }
}

