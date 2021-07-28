package com.chaosbuffalo.spartanfire;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;

import java.util.ArrayList;

/**
 * Created by Jacob on 7/20/2018.
 */
public class IAFMatConverter {

    public final WeaponMaterial material;

    public final String name;

    public final ArrayList<WeaponTrait> properties;

    public IAFMatConverter(String name, WeaponMaterial material, WeaponTrait... properties) {
        this.name = name;
        this.material = material;
        this.properties = new ArrayList<>();
        for (WeaponTrait prop : properties){
            this.properties.add(prop);
        }
    }
}
