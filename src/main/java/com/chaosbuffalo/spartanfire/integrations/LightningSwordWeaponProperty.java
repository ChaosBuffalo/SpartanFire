package com.chaosbuffalo.spartanfire.integrations;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.MeleeCallbackWeaponTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class LightningSwordWeaponProperty extends MeleeCallbackWeaponTrait {

    public LightningSwordWeaponProperty(String propType, String propModId) {
        super(propType, propModId, TraitQuality.POSITIVE);
    }

    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
        boolean flag = true;
        if(attacker instanceof PlayerEntity){
            if(((PlayerEntity)attacker).swingProgress > 0.2){
                flag = false;
            }
        }
        if(!attacker.world.isRemote && flag){
            LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(target.world);
            assert lightningboltentity != null;
            lightningboltentity.moveForced(target.getPositionVec());
            if(!target.world.isRemote){
                target.world.addEntity(lightningboltentity);
            }
        }
        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 300, 2));
        target.applyKnockback(1F, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());
    }
}
