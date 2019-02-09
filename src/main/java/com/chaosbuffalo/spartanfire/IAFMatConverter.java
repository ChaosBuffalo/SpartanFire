package com.chaosbuffalo.spartanfire;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;

import java.util.ArrayList;

/**
 * Created by Jacob on 7/20/2018.
 */
public class IAFMatConverter {

    public final ToolMaterialEx material;

    public final String name;

    public final ArrayList<WeaponProperty> properties;

    public IAFMatConverter(String name, ToolMaterialEx material, WeaponProperty... properties) {
        this.name = name;
        this.material = material;
        this.properties = new ArrayList<>();
        for (WeaponProperty prop : properties){
            this.properties.add(prop);
        }
    }
}
