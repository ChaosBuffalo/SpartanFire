package com.chaosbuffalo.spartanfire.integrations;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class FireSwordWeaponProperty extends MeleeCallbackWeaponTrait {

    public FireSwordWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
        if (target instanceof EntityIceDragon) {
            target.hurt(DamageSource.IN_FIRE, 13.5F);
        }
        target.setSecondsOnFire(5);
        target.knockback(1F, attacker.position().x - target.position().x, attacker.position().z - target.position().z);
    }
}
