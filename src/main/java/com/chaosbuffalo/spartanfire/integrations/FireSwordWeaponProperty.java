package com.chaosbuffalo.spartanfire.integrations;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class FireSwordWeaponProperty extends WeaponPropertyWithCallback {

    public FireSwordWeaponProperty(String propType, String propModId) {
        super(propType, propModId);
    }

    public void onHitEntity(ToolMaterialEx material, ItemStack stack, EntityLivingBase target, EntityLivingBase attacker, Entity projectile) {
        if (target instanceof EntityIceDragon) {
            target.attackEntityFrom(DamageSource.IN_FIRE, 13.5F);
        }
        target.setFire(5);
        target.knockBack(target, 1F, attacker.posX - target.posX, attacker.posZ - target.posZ);
    }
}
