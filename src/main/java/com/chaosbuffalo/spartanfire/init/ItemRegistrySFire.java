package com.chaosbuffalo.spartanfire.init;

import com.chaosbuffalo.spartanfire.SpartanFire;
import com.chaosbuffalo.spartanfire.Utils;
import com.chaosbuffalo.spartanfire.integrations.*;
import com.chaosbuffalo.spartanfire.items.SFItem;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.util.Config;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import java.util.*;

/**
 * Created by Jacob on 7/20/2018.
 */@Mod.EventBusSubscriber
public class ItemRegistrySFire {
    public static final Set<WeaponMaterial> MATERIALS_TO_REGISTER = new LinkedHashSet<>();

    public static final String DRAGONBONE = "dragonbone";
    public static final String DRAGONBONE_FIRE = "dragonbone_fire";
    public static final String DRAGONBONE_ICE = "dragonbone_ice";
    public static final String DRAGONBONE_LIGHTNING = "dragonbone_lightning";
    public static final String MYRMEXJUNGLE = "myrmexjungle";
    public static final String MYRMEXJUNGLE_VENOM = "myrmexjungle_venom";
    public static final String MYRMEXDESERT = "myrmexdesert";
    public static final String MYRMEXDESERT_VENOM = "myrmexdesert_venom";
    public static final String DRAGONSTEEL_FIRE = "dragonsteel_fire";
    public static final String DRAGONSTEEL_ICE = "dragonsteel_ice";
    public static final String DRAGONSTEEL_LIGHTNING = "dragonsteel_lightning";

    private static final Set<Item> ALL_ITEMS = new HashSet<>();

    static {
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONBONE,
                        IafItemRegistry.DRAGONBONE_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonbone"));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONBONE_FIRE,
                        IafItemRegistry.FIRE_DRAGONBONE_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonbone",
                        new FireSwordWeaponProperty(DRAGONBONE_FIRE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONBONE_ICE,
                        IafItemRegistry.ICE_DRAGONBONE_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonbone",
                        new IceSwordWeaponProperty(DRAGONBONE_ICE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONBONE_LIGHTNING,
                        IafItemRegistry.LIGHTNING_DRAGONBONE_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonbone",
                        new LightningSwordWeaponProperty(DRAGONBONE_LIGHTNING, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        MYRMEXJUNGLE,
                        IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "myrmexjungle",
                        new MyrmexSwordProperty(MYRMEXJUNGLE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        MYRMEXDESERT,
                        IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "myrmexdesert",
                        new MyrmexSwordProperty(MYRMEXDESERT, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        MYRMEXJUNGLE_VENOM,
                        IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "myrmexjungle",
                        new MyrmexSwordProperty(MYRMEXJUNGLE, SpartanFire.MODID),
                        new MyrmexPoisonSwordProperty(MYRMEXJUNGLE_VENOM, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        MYRMEXDESERT_VENOM,
                        IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "myrmexdesert",
                        new MyrmexSwordProperty(MYRMEXDESERT, SpartanFire.MODID),
                        new MyrmexPoisonSwordProperty(MYRMEXDESERT_VENOM, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONSTEEL_ICE,
                        IafItemRegistry.DRAGONSTEEL_ICE_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonsteel_ice",
                        new IceDragonsteelWeaponProperty(DRAGONSTEEL_ICE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONSTEEL_FIRE,
                        IafItemRegistry.DRAGONSTEEL_FIRE_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonsteel fire",
                        new FireDragonsteelWeaponProperty(DRAGONSTEEL_FIRE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(
                Utils.spartanMatFromToolMat(
                        DRAGONSTEEL_LIGHTNING,
                        IafItemRegistry.DRAGONSTEEL_LIGHTNING_TOOL_MATERIAL,
                        9867904,
                        14999238,
                        "dragonsteel_lightning",
                        new LightningDragonsteelWeaponProperty(DRAGONSTEEL_LIGHTNING, SpartanFire.MODID)));
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev) {
        Set<Item> item_set = new LinkedHashSet<>();
        Item witherboneHandle = new SFItem(new ResourceLocation(SpartanFire.MODID, "witherbone_handle"),
                IceAndFire.TAB_ITEMS);
        Item witherbonePole = new SFItem(new ResourceLocation(SpartanFire.MODID, "witherbone_pole"),
                IceAndFire.TAB_ITEMS);
        ALL_ITEMS.add(witherboneHandle);
        ALL_ITEMS.add(witherbonePole);
        for (WeaponMaterial mat : MATERIALS_TO_REGISTER){
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.katanas)){
                Item katana = SpartanWeaponryAPI.createKatana(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(katana);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.greatswords)){
                Item greatsword = SpartanWeaponryAPI.createGreatsword(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(greatsword);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.longswords)){
                Item longsword = SpartanWeaponryAPI.createLongsword(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(longsword);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.sabers)){
                Item saber = SpartanWeaponryAPI.createSaber(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(saber);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.rapiers)){
                Item rapier = SpartanWeaponryAPI.createRapier(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(rapier);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.daggers)) {
                Item dagger = SpartanWeaponryAPI.createDagger(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(dagger);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.spears)) {
                Item spear = SpartanWeaponryAPI.createSpear(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(spear);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.pikes)) {
                Item pike = SpartanWeaponryAPI.createPike(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(pike);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.lances)) {
                Item lance = SpartanWeaponryAPI.createLance(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(lance);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.halberds)) {
                Item halberd = SpartanWeaponryAPI.createHalberd(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(halberd);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.warhammers)) {
                Item warhammer = SpartanWeaponryAPI.createWarhammer(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(warhammer);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.battleHammers)) {
                Item hammer = SpartanWeaponryAPI.createBattleHammer(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(hammer);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.tomahawks)) {
                Item throwing_axe = SpartanWeaponryAPI.createTomahawk(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(throwing_axe);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.throwingKnives)) {
                Item throwing_knife = SpartanWeaponryAPI.createThrowingKnife(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(throwing_knife);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.longbows)) {
                Item longbow = SpartanWeaponryAPI.createLongbow(
                        mat,
                        IceAndFire.TAB_ITEMS
                );

                item_set.add(longbow);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.heavyCrossbows)) {
                Item crossbow = SpartanWeaponryAPI.createHeavyCrossbow(
                        mat,
                        IceAndFire.TAB_ITEMS
                );

                item_set.add(crossbow);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.javelins)) {
                Item javelin = SpartanWeaponryAPI.createJavelin(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(javelin);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.battleaxes)) {
                Item battleaxe = SpartanWeaponryAPI.createBattleaxe(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(battleaxe);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.boomerangs)) {
                Item boomerang = SpartanWeaponryAPI.createBoomerang(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(boomerang);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.flangedMaces)) {
                Item mace = SpartanWeaponryAPI.createFlangedMace(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(mace);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.quarterstaves)){
                Item quarterstaff = SpartanWeaponryAPI.createQuarterstaff(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(quarterstaff);
            }
            if (Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.glaives)){
                Item glaive = SpartanWeaponryAPI.createGlaive(
                        mat,
                        IceAndFire.TAB_ITEMS
                );
                item_set.add(glaive);
            }
        }
        for (Item it : item_set){
            ev.getRegistry().register(it);
        }
        ALL_ITEMS.forEach(ev.getRegistry()::register);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ALL_ITEMS.stream()
                .filter(item -> item.getRegistryName() != null)
                .forEach(item -> new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
