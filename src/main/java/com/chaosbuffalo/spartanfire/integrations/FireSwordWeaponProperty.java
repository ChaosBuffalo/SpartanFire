package com.chaosbuffalo.spartanfire.integrations;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTraitWithCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class FireSwordWeaponProperty extends WeaponTraitWithCallback {

    public FireSwordWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target,
                            LivingEntity attacker, Entity projectile) {
        if (target instanceof EntityIceDragon) {
            target.attackEntityFrom(DamageSource.IN_FIRE, 13.5F);
        }
        target.setFire(5);
        target.knockBack(target, 1F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
    }
}
