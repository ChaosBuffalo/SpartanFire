package com.chaosbuffalo.spartanfire.data;

import com.chaosbuffalo.spartanfire.SpartanFire;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.List;

public class SpartanFireModelProvider extends ItemModelProvider {

    public SpartanFireModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SpartanFire.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Material List
        List<String> materials = new ArrayList<>();
        materials.add("dragonbone");
        materials.add("dragonbone_fire");
        materials.add("dragonbone_ice");
        materials.add("dragonbone_lightning");
        materials.add("myrmexjungle");
        materials.add("myrmexjungle_venom");
        materials.add("myrmexdesert");
        materials.add("myrmexdesert_venom");
        materials.add("dragonsteel_fire");
        materials.add("dragonsteel_ice");
        materials.add("dragonsteel_lightning");

        List<String> meleeWeaponType = new ArrayList<>();
        meleeWeaponType.add("dagger");
        meleeWeaponType.add("longsword");
        meleeWeaponType.add("katana");
        meleeWeaponType.add("saber");
        meleeWeaponType.add("rapier");
        meleeWeaponType.add("greatsword");
        meleeWeaponType.add("battlehammer");
        meleeWeaponType.add("warhammer");
        meleeWeaponType.add("spear");
        meleeWeaponType.add("halberd");
        meleeWeaponType.add("pike");
        meleeWeaponType.add("lance");
        meleeWeaponType.add("longbow");
        meleeWeaponType.add("heavy_crossbow");
        meleeWeaponType.add("throwing_knife");
        meleeWeaponType.add("tomahawk");
        meleeWeaponType.add("javelin");
        meleeWeaponType.add("boomerang");
        meleeWeaponType.add("battleaxe");
        meleeWeaponType.add("flanged_mace");
        meleeWeaponType.add("glaive");
        meleeWeaponType.add("quarterstaff");

        List<String> rangedWeaponType = new ArrayList<>();
        rangedWeaponType.add("longbow");
        rangedWeaponType.add("heavy_crossbow");

        for (String weapon : meleeWeaponType) {
            for (String material : materials) {
                makeMeleeModel(weapon, material);
            }
        }

        for (String weapon : rangedWeaponType) {
            for (String material : materials) {
                makeRangedModel(weapon, material);
            }
        }

        getBuilder("item/witherbone_handle")
                .parent(getExistingFile(modLoc("spartanweaponry:item/standard_item")))
                .texture("0", modLoc("item/witherbone_handle"));

        getBuilder("item/witherbone_pole")
                .parent(getExistingFile(modLoc("spartanweaponry:item/standard_item")))
                .texture("0", modLoc("item/witherbone_pole"));
    }

    private void makeMeleeModel(String weapon, String material) {
        String path = "item/" + weapon + "_" + material;
        getBuilder(path)
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood")))
                .texture("0", modLoc(path));
    }

    private void makeRangedModel(String weapon, String material) {
        String path = "item/" + weapon + "_" + material;

        getBuilder(path)
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood")))
                .texture("0", modLoc(path + "_standby"))
                .override().predicate(new ResourceLocation("pulling"), 1).model(getExistingFile(modLoc(path + "_pulling_0")))
                .predicate(new ResourceLocation("pull"), (float) 0.65).predicate(new ResourceLocation("pulling"), 1).model(getExistingFile(modLoc(path + "_pulling_2")))
                .predicate(new ResourceLocation("pull"), 1).predicate(new ResourceLocation("pulling"), 0).model(getExistingFile(modLoc(path + "_loaded")))
                .predicate(new ResourceLocation("pull"), 1).predicate(new ResourceLocation("pulling"), 1).model(getExistingFile(modLoc(path + "_firing")));

        getBuilder(path + "_firing")
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood_pulling_0")))
                .texture("0", modLoc(path + "_loaded"));

        getBuilder(path + "_loaded")
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood")))
                .texture("0", modLoc(path + "_loaded"));

        getBuilder(path + "_pulling_0")
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood_pulling_0")))
                .texture("0", modLoc(path + "_pulling_0"));

        getBuilder(path + "_pulling_1")
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood_pulling_0")))
                .texture("0", modLoc(path + "_pulling_1"));

        getBuilder(path + "_pulling_2")
                .parent(getExistingFile(modLoc("spartanweaponry:item/" + weapon + "_wood_pulling_0")))
                .texture("0", modLoc(path + "_pulling_2"));
        }
    }
    
    


    //private void makeWeaponModel(WeaponMaterial material) {
    //    String path = String.format("item/dagger_%s", material.getTagName().getPath());
    //    getBuilder(path)
    //            .parent(getExistingFile(modLoc("spartanweaponry:item/dagger_wood")))
    //            .texture("0", modLoc(path));

    //}
