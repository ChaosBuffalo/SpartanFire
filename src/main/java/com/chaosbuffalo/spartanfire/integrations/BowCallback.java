package com.chaosbuffalo.spartanfire.integrations;

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class BowCallback implements IWeaponCallback {
    @Override
    public void onTooltip(ToolMaterialEx toolMaterialEx, ItemStack itemStack, World world, List<String> list, ITooltipFlag iTooltipFlag) {

    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx toolMaterialEx, float v, DamageSource damageSource, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
        return 0;
    }

    @Override
    public float modifyDamageTaken(ToolMaterialEx toolMaterialEx, float v, DamageSource damageSource, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
        return 0;
    }

    @Override
    public void onItemUpdate(ToolMaterialEx toolMaterialEx, ItemStack itemStack, World world, EntityLivingBase entityLivingBase, int i, boolean b) {

    }

    @Override
    public void onHitEntity(ToolMaterialEx toolMaterialEx, ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1, Entity entity) {

    }

    @Override
    public void onCreateItem(ToolMaterialEx toolMaterialEx, ItemStack itemStack) {

    }
}
