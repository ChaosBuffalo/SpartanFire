package com.chaosbuffalo.spartanfire.init;

import com.chaosbuffalo.spartanfire.IAFMatConverter;
import com.chaosbuffalo.spartanfire.SpartanFire;
import com.chaosbuffalo.spartanfire.utils;
import com.github.alexthe666.iceandfire.core.ModItems;
import com.oblivioussp.spartanweaponry.client.gui.CreativeTabsSW;
import com.oblivioussp.spartanweaponry.init.ModelRenderRegistry;
import com.oblivioussp.spartanweaponry.item.*;
import com.oblivioussp.spartanweaponry.util.DamageHelper;
import com.oblivioussp.spartanweaponry.util.ToolMaterialEx;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jacob on 7/20/2018.
 */@Mod.EventBusSubscriber
public class ItemRegistrySFire {
    public static final Set<IAFMatConverter> MATERIALS_TO_REGISTER = new HashSet<>();

    public static final String DRAGONBONE = "dragonbone";
    static {
        MATERIALS_TO_REGISTER.add(new IAFMatConverter(DRAGONBONE,
                utils.spartanMatFromToolMat(DRAGONBONE, ModItems.boneTools,
                9867904, 14999238)));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> ev) {
        Set<Item> item_set = new HashSet<>();
        for (IAFMatConverter mat : MATERIALS_TO_REGISTER){
            ItemKatana katana = new ItemKatana("katana_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.KATANA, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(katana, mat.material, "katana_custom");
            item_set.add(katana);
            ItemGreatsword greatsword = new ItemGreatsword("greatsword_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.GREATSWORD, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(greatsword, mat.material, "greatsword_custom");
            item_set.add(greatsword);
            ItemLongsword longsword = new ItemLongsword("longsword_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.LONGSWORD, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(longsword, mat.material, "longsword_custom");
            item_set.add(longsword);
            ItemSaber saber = new ItemSaber("saber_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.SABER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(saber, mat.material, "saber_custom");
            item_set.add(saber);
            ItemRapier rapier = new ItemRapier("rapier_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.RAPIER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(rapier, mat.material, "rapier_custom");
            item_set.add(rapier);
            ItemDagger dagger = new ItemDagger("dagger_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.DAGGER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(dagger, mat.material, "dagger_custom");
            item_set.add(dagger);
            ItemSpear spear = new ItemSpear("spear_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.SPEAR, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(spear, mat.material, "spear_custom");
            item_set.add(spear);
            ItemPike pike = new ItemPike("pike_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.PIKE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(pike, mat.material, "pike_custom");
            item_set.add(pike);
            ItemLance lance = new ItemLance("lance_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.LANCE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(lance, mat.material, "lance_custom");
            item_set.add(lance);
            ItemHalberd halberd = new ItemHalberd("halberd_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.HALBERD, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(halberd, mat.material, "halberd_custom");
            item_set.add(halberd);
            ItemWarhammer warhammer = new ItemWarhammer("warhammer_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.WARHAMMER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(warhammer, mat.material, "warhammer_custom");
            item_set.add(warhammer);
            ItemHammer hammer = new ItemHammer("hammer_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.HAMMER, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(hammer, mat.material, "hammer_custom");
            item_set.add(hammer);
            ItemThrowingAxe throwing_axe = new ItemThrowingAxe("throwing_axe_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.THROWING_AXE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(throwing_axe, mat.material, "throwing_axe_custom");
            item_set.add(throwing_axe);
            ItemThrowingKnife throwing_knife = new ItemThrowingKnife("throwing_knife_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.THROWING_KNIFE, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(throwing_knife, mat.material, "throwing_knife_custom");
            item_set.add(throwing_knife);
            ItemLongbow longbow = new ItemLongbow("longbow_" + mat.name, SpartanFire.MODID, mat.material);
            ModelRenderRegistry.addItemToRegistry(longbow, mat.material, "longbow_custom");
            item_set.add(longbow);
            ItemCrossbow crossbow = new ItemCrossbow("crossbow_" + mat.name, SpartanFire.MODID, mat.material);
            ModelRenderRegistry.addItemToRegistry(crossbow, mat.material, "crossbow_custom");
            item_set.add(crossbow);
            ItemJavelin javelin = new ItemJavelin("javelin_" + mat.name, SpartanFire.MODID, mat.material,
                    DamageHelper.getDamage(DamageHelper.WeaponType.JAVELIN, mat.material.getMaterial().getAttackDamage()));
            ModelRenderRegistry.addItemToRegistry(javelin, mat.material, "javelin_custom");
            item_set.add(javelin);

        }
        for (Item it : item_set){
            it.setCreativeTab(CreativeTabsSW.TAB_SW);
            ev.getRegistry().register(it);
        }
    }
}
