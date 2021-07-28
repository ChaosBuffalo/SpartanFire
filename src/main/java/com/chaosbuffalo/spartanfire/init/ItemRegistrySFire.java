package com.chaosbuffalo.spartanfire.init;

import com.chaosbuffalo.spartanfire.IAFMatConverter;
import com.chaosbuffalo.spartanfire.SpartanFire;
import com.chaosbuffalo.spartanfire.integrations.*;
import com.chaosbuffalo.spartanfire.Utils;
import com.chaosbuffalo.spartanfire.items.SFItem;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.util.Config;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
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
    public static final String JUNGLE = "jungle";
    public static final String JUNGLE_VENOM = "jungle_venom";
    public static final String DESERT = "desert";
    public static final String DESERT_VENOM = "desert_venom";
    public static final String FIRE_DRAGONSTEEL = "fire_dragonsteel";
    public static final String ICE_DRAGONSTEEL = "ice_dragonsteel";

    private static final Set<Item> ALL_ITEMS = new HashSet<>();

    static {
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(DRAGONBONE,
                Utils.spartanMatFromToolMat(DRAGONBONE, IafItemRegistry.DRAGONBONE_TOOL_MATERIAL,
                9867904, 14999238, "ingotDragonbone")));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(FIRE_DRAGONBONE,
                Utils.spartanMatFromToolMat(FIRE_DRAGONBONE, IafItemRegistry.FIRE_DRAGONBONE_TOOL_MATERIAL,
                9867904, 14999238, "ingotDragonbone"),
                new FireSwordWeaponProperty(FIRE_DRAGONBONE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(ICE_DRAGONBONE,
                Utils.spartanMatFromToolMat(ICE_DRAGONBONE, IafItemRegistry.ICE_DRAGONBONE_TOOL_MATERIAL,
                        9867904, 14999238, "ingotDragonbone"),
                new IceSwordWeaponProperty(ICE_DRAGONBONE, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(JUNGLE,
                Utils.spartanMatFromToolMat(JUNGLE, IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904, 14999238, "ingotJungleChitin"),
                new MyrmexSwordProperty(JUNGLE, SpartanFire.MODID)
                ));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(DESERT,
                Utils.spartanMatFromToolMat(DESERT, IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904, 14999238, "ingotDesertChitin"),
                new MyrmexSwordProperty(DESERT, SpartanFire.MODID)
        ));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(JUNGLE_VENOM,
                Utils.spartanMatFromToolMat(JUNGLE_VENOM, IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904, 14999238, "ingotJungleChitin"),
                new MyrmexSwordProperty(JUNGLE, SpartanFire.MODID),
                new MyrmexPoisonSwordProperty(JUNGLE_VENOM, SpartanFire.MODID)
        ));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(DESERT_VENOM,
                Utils.spartanMatFromToolMat(DESERT_VENOM, IafItemRegistry.MYRMEX_CHITIN_TOOL_MATERIAL,
                        9867904, 14999238, "ingotDesertChitin"),
                new MyrmexSwordProperty(DESERT, SpartanFire.MODID),
                new MyrmexPoisonSwordProperty(DESERT_VENOM, SpartanFire.MODID)
        ));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(ICE_DRAGONSTEEL,
                Utils.spartanMatFromToolMat(ICE_DRAGONSTEEL, IafItemRegistry.DRAGONSTEEL_ICE_TOOL_MATERIAL,

                        9867904, 14999238, "ingotIceDragonsteel"),
                new IceDragonsteelWeaponProperty(ICE_DRAGONSTEEL, SpartanFire.MODID)));
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(FIRE_DRAGONSTEEL,
                Utils.spartanMatFromToolMat(FIRE_DRAGONSTEEL, IafItemRegistry.DRAGONSTEEL_FIRE_TOOL_MATERIAL,
                        9867904, 14999238, "ingotFireDragonsteel"),
                new FireDragonsteelWeaponProperty(FIRE_DRAGONSTEEL, SpartanFire.MODID)));

    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev) {
        // Don't know why this was left out from ice and fire
        OreDictionary.registerOre("ingotDragonbone", IafItemRegistry.dragonbone);
        OreDictionary.registerOre("ingotJungleChitin", IafItemRegistry.myrmex_jungle_chitin);
        OreDictionary.registerOre("ingotDesertChitin", IafItemRegistry.myrmex_desert_chitin);


        Set<Item> item_set = new LinkedHashSet<>();
        Item witherboneHandle = new SFItem(new ResourceLocation(SpartanFire.MODID, "witherbone_handle"),
                IceAndFire.TAB_ITEMS);
        Item witherbonePole = new SFItem(new ResourceLocation(SpartanFire.MODID, "witherbone_pole"),
                IceAndFire.TAB_ITEMS);
        ALL_ITEMS.add(witherboneHandle);
        ALL_ITEMS.add(witherbonePole);
        for (IAFMatConverter mat : MATERIALS_TO_REGISTER){
            if (!Config.INSTANCE.disabledRecipeTypes.contains(Config.INSTANCE.katanas)){
                Item katana = SpartanWeaponryAPI.createKatana(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(katana,
                        "katana_" + mat.material.getUnlocName());
                item_set.add(katana);
            }
            if (!ConfigHandler.disableGreatsword){
                Item greatsword = SpartanWeaponryAPI.createGreatsword(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(greatsword, "greatsword_" + mat.material.getUnlocName());
                item_set.add(greatsword);
            }
            if (!ConfigHandler.disableLongsword){
                Item longsword = SpartanWeaponryAPI.createLongsword(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(longsword, "longsword_" + mat.material.getUnlocName());
                item_set.add(longsword);
            }
            if (!ConfigHandler.disableSaber){
                Item saber = SpartanWeaponryAPI.createSaber(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(saber, "saber_" + mat.material.getUnlocName());
                item_set.add(saber);
            }
            if (!ConfigHandler.disableRapier){
                Item rapier = SpartanWeaponryAPI.createRapier(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(rapier, "rapier_" + mat.material.getUnlocName());
                item_set.add(rapier);
            }
            if (!ConfigHandler.disableDagger) {
                Item dagger = SpartanWeaponryAPI.createDagger(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(dagger,"dagger_" + mat.material.getUnlocName());
                item_set.add(dagger);
            }
            if (!ConfigHandler.disableSpear) {
                Item spear = SpartanWeaponryAPI.createSpear(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(spear,"spear_" + mat.material.getUnlocName());
                item_set.add(spear);
            }
            if (!ConfigHandler.disablePike) {
                Item pike = SpartanWeaponryAPI.createPike(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(pike, "pike_" + mat.material.getUnlocName());
                item_set.add(pike);
            }
            if (!ConfigHandler.disableLance) {
                Item lance = SpartanWeaponryAPI.createLance(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(lance, "lance_" + mat.material.getUnlocName());
                item_set.add(lance);
            }
            if (!ConfigHandler.disableHalberd) {
                Item halberd = SpartanWeaponryAPI.createHalberd(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(halberd, "halberd_" + mat.material.getUnlocName());
                item_set.add(halberd);
            }
            if (!ConfigHandler.disableWarhammer) {
                Item warhammer = SpartanWeaponryAPI.createWarhammer(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(warhammer, "warhammer_" + mat.material.getUnlocName());
                item_set.add(warhammer);
            }
            if (!ConfigHandler.disableHammer) {
                Item hammer = SpartanWeaponryAPI.createHammer(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(hammer,"hammer_" + mat.material.getUnlocName());
                item_set.add(hammer);
            }
            if (!ConfigHandler.disableThrowingAxe) {
                Item throwing_axe = SpartanWeaponryAPI.createThrowingAxe(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(throwing_axe,
                        "throwing_axe_" + mat.material.getUnlocName());
                item_set.add(throwing_axe);
            }
            if (!ConfigHandler.disableThrowingKnife) {
                Item throwing_knife = SpartanWeaponryAPI.createThrowingKnife(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(throwing_knife,
                        "throwing_knife_" + mat.material.getUnlocName());
                item_set.add(throwing_knife);
            }
            if (!ConfigHandler.disableLongbow && !ConfigHandler.woodenLongbowOnly) {
                Item longbow = SpartanWeaponryAPI.createLongbow(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        null
                );

                ModelRenderRegistrySFire.addItemToRegistry(longbow, "longbow_" + mat.material.getUnlocName());
                item_set.add(longbow);
            }
            if (!ConfigHandler.disableCrossbow && !ConfigHandler.woodenCrossbowOnly) {
                Item crossbow = SpartanWeaponryAPI.createCrossbow(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        null
                );

                ModelRenderRegistrySFire.addItemToRegistry(crossbow,"crossbow_" + mat.material.getUnlocName());
                item_set.add(crossbow);
            }
            if (!ConfigHandler.disableJavelin) {
                Item javelin = SpartanWeaponryAPI.createJavelin(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(javelin,"javelin_" + mat.material.getUnlocName());
                item_set.add(javelin);
            }
            if (!ConfigHandler.disableBattleaxe) {
                Item battleaxe = SpartanWeaponryAPI.createBattleaxe(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(battleaxe, "battleaxe_" + mat.material.getUnlocName());
                item_set.add(battleaxe);
            }
            if (!ConfigHandler.disableBoomerang && !ConfigHandler.woodenBoomerangOnly) {
                Item boomerang = SpartanWeaponryAPI.createBoomerang(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(boomerang,
                        "boomerang_" + mat.material.getUnlocName());
                item_set.add(boomerang);
            }
            if (!ConfigHandler.disableMace) {
                Item mace = SpartanWeaponryAPI.createMace(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(mace, "mace_" + mat.material.getUnlocName());
                item_set.add(mace);
            }
            if (!ConfigHandler.disableQuarterstaff){
                Item quarterstaff = SpartanWeaponryAPI.createQuarterstaff(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(quarterstaff, "staff_" + mat.material.getUnlocName());
                item_set.add(quarterstaff);
            }
            if (!ConfigHandler.disableGlaive){
                Item glaive = SpartanWeaponryAPI.createGlaive(
                        mat.material,
                        SpartanFire.MODID,
                        IceAndFire.TAB_ITEMS,
                        mat.properties.toArray(new WeaponProperty[0])
                );
                ModelRenderRegistrySFire.addItemToRegistry(glaive, "glaive_" + mat.material.getUnlocName());
                item_set.add(glaive);
            }
            if (ConfigHandler.enableExperimentalWeapons && !ConfigHandler.disableParryingDagger){
                //empty method for now till a create parrying dagger method is created
            }
        }
        for (Item it : item_set){
            ev.getRegistry().register(it);
        }
        ALL_ITEMS.forEach(ev.getRegistry()::register);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ALL_ITEMS.stream()
                .filter(item -> item.getRegistryName() != null)
                .forEach(item ->
                        ModelLoader.setCustomModelResourceLocation(item, 0,
                                new ModelResourceLocation(item.getRegistryName(), "inventory")));
    }
}
