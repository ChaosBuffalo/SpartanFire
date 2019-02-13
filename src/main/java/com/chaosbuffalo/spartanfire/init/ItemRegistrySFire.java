package com.chaosbuffalo.spartanfire.init;

import com.chaosbuffalo.spartanfire.IAFMatConverter;
import com.chaosbuffalo.spartanfire.SpartanFire;
import com.chaosbuffalo.spartanfire.integrations.FireSwordWeaponProperty;
import com.chaosbuffalo.spartanfire.integrations.IceSwordWeaponProperty;
import com.chaosbuffalo.spartanfire.utils;
import com.github.alexthe666.iceandfire.core.ModItems;
import com.oblivioussp.spartanweaponry.api.DamageHelper;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.util.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Jacob on 7/20/2018.
 */@Mod.EventBusSubscriber
public class ItemRegistrySFire {
    public static final Set<IAFMatConverter> MATERIALS_TO_REGISTER = new LinkedHashSet<>();

    public static final String DRAGONBONE = "dragonbone";
    public static final String FIRE_DRAGONBONE = "fire_dragonbone";
    public static final String ICE_DRAGONBONE = "ice_dragonbone";
    static {
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(DRAGONBONE,
                utils.spartanMatFromToolMat(DRAGONBONE, ModItems.boneTools,
                9867904, 14999238)));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(FIRE_DRAGONBONE,
                utils.spartanMatFromToolMat(FIRE_DRAGONBONE, ModItems.fireBoneTools,
                9867904, 14999238),
                new FireSwordWeaponProperty(FIRE_DRAGONBONE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(ICE_DRAGONBONE,
                utils.spartanMatFromToolMat(ICE_DRAGONBONE, ModItems.iceBoneTools,
                        9867904, 14999238),
                new IceSwordWeaponProperty(ICE_DRAGONBONE, SpartanFire.MODID)));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev) {
        // Don't know why this was left out from ice and fire
        OreDictionary.registerOre("ingotDragonbone", ModItems.dragonbone);
        Set<Item> item_set = new LinkedHashSet<>();
        for (IAFMatConverter mat : MATERIALS_TO_REGISTER){
            if (!ConfigHandler.disableKatana){
                Item katana = SpartanWeaponryAPI.createKatana(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.KATANA,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(katana,
                        "katana_" + mat.material.getUnlocName());
                item_set.add(katana);
            }
            if (!ConfigHandler.disableGreatsword){
                Item greatsword = SpartanWeaponryAPI.createGreatsword(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.GREATSWORD,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,

                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(greatsword, "greatsword_" + mat.material.getUnlocName());
                item_set.add(greatsword);
            }
            if (!ConfigHandler.disableLongsword){
                Item longsword = SpartanWeaponryAPI.createLongsword(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.LONGSWORD,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(longsword, "longsword_" + mat.material.getUnlocName());
                item_set.add(longsword);
            }
            if (!ConfigHandler.disableSaber){
                Item saber = SpartanWeaponryAPI.createSaber(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.SABER,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(saber, "saber_" + mat.material.getUnlocName());
                item_set.add(saber);
            }
            if (!ConfigHandler.disableRapier){
                Item rapier = SpartanWeaponryAPI.createRapier(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.RAPIER,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(rapier, "rapier_" + mat.material.getUnlocName());
                item_set.add(rapier);
            }
            if (!ConfigHandler.disableDagger) {
                Item dagger = SpartanWeaponryAPI.createDagger(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.DAGGER,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(dagger,"dagger_" + mat.material.getUnlocName());
                item_set.add(dagger);
            }
            if (!ConfigHandler.disableSpear) {
                Item spear = SpartanWeaponryAPI.createSpear(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.SPEAR,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(spear,"spear_" + mat.material.getUnlocName());
                item_set.add(spear);
            }
            if (!ConfigHandler.disablePike) {
                Item pike = SpartanWeaponryAPI.createPike(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.PIKE,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(pike, "pike_" + mat.material.getUnlocName());
                item_set.add(pike);
            }
            if (!ConfigHandler.disableLance) {
                Item lance = SpartanWeaponryAPI.createLance(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.LANCE,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(lance, "lance_" + mat.material.getUnlocName());
                item_set.add(lance);
            }
            if (!ConfigHandler.disableHalberd) {
                Item halberd = SpartanWeaponryAPI.createHalberd(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.HALBERD,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(halberd, "halberd_" + mat.material.getUnlocName());
                item_set.add(halberd);
            }
            if (!ConfigHandler.disableWarhammer) {
                Item warhammer = SpartanWeaponryAPI.createWarhammer(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.WARHAMMER,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(warhammer, "warhammer_" + mat.material.getUnlocName());
                item_set.add(warhammer);
            }
            if (!ConfigHandler.disableHammer) {
                Item hammer = SpartanWeaponryAPI.createHammer(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.HAMMER,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(hammer,"hammer_" + mat.material.getUnlocName());
                item_set.add(hammer);
            }
            if (!ConfigHandler.disableThrowingAxe) {
                Item throwing_axe = SpartanWeaponryAPI.createThrowingAxe(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.THROWING_AXE,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(throwing_axe,
                        "throwing_axe_" + mat.material.getUnlocName());
                item_set.add(throwing_axe);
            }
            if (!ConfigHandler.disableThrowingKnife) {
                Item throwing_knife = SpartanWeaponryAPI.createThrowingKnife(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.THROWING_KNIFE,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(throwing_knife,
                        "throwing_knife_" + mat.material.getUnlocName());
                item_set.add(throwing_knife);
            }
            if (!ConfigHandler.disableLongbow && !ConfigHandler.woodenLongbowOnly) {
                Item longbow = SpartanWeaponryAPI.createLongbow(
                        mat.material,
                        SpartanFire.MODID,
                        CreativeTabsSW.TAB_SW,
                        null
                );

                ModelRenderRegistrySFire.addItemToRegistry(longbow, "longbow_" + mat.material.getUnlocName());
                item_set.add(longbow);
            }
            if (!ConfigHandler.disableCrossbow && !ConfigHandler.woodenCrossbowOnly) {
                Item crossbow = SpartanWeaponryAPI.createCrossbow(
                        mat.material,
                        SpartanFire.MODID,
                        CreativeTabsSW.TAB_SW,
                        null
                );

                ModelRenderRegistrySFire.addItemToRegistry(crossbow,"crossbow_" + mat.material.getUnlocName());
                item_set.add(crossbow);
            }
            if (!ConfigHandler.disableJavelin) {
                Item javelin = SpartanWeaponryAPI.createJavelin(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.JAVELIN,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(javelin,"javelin_" + mat.material.getUnlocName());
                item_set.add(javelin);
            }
            if (!ConfigHandler.disableBattleaxe) {
                Item battleaxe = SpartanWeaponryAPI.createBattleaxe(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.BATTLEAXE,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(battleaxe, "battleaxe_" + mat.material.getUnlocName());
                item_set.add(battleaxe);
            }
            if (!ConfigHandler.disableBoomerang && !ConfigHandler.woodenBoomerangOnly) {
                Item boomerang = SpartanWeaponryAPI.createBoomerang(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.BOOMERANG,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(boomerang,
                        "boomerang_" + mat.material.getUnlocName());
                item_set.add(boomerang);
            }
            if (!ConfigHandler.disableMace) {
                Item mace = SpartanWeaponryAPI.createMace(
                        mat.material,
                        SpartanFire.MODID,
                        DamageHelper.getDamage(DamageHelper.WeaponType.MACE,
                                mat.material.getMaterial().getAttackDamage()),
                        CreativeTabsSW.TAB_SW,
                        mat.properties.toArray(new WeaponProperty[mat.properties.size()])
                );
                ModelRenderRegistrySFire.addItemToRegistry(mace, "mace_" + mat.material.getUnlocName());
                item_set.add(mace);
            }
            if (ConfigHandler.enableExperimentalWeapons && !ConfigHandler.disableParryingDagger){
                //empty method for now till a create parrying dagger method is created
            }
        }
        for (Item it : item_set){
            it.setCreativeTab(CreativeTabsSW.TAB_SW);
            ev.getRegistry().register(it);
        }
    }
}
