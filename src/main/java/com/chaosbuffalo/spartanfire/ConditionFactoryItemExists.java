package com.chaosbuffalo.spartanfire;

import com.google.gson.JsonObject;
import com.oblivioussp.spartanweaponry.util.ConfigHandler;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.function.BooleanSupplier;

public class ConditionFactoryItemExists implements IConditionFactory {
    public ConditionFactoryItemExists() {
    }

    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        String itemName = json.get("item").getAsString();
        boolean result = !GameRegistry.makeItemStack(itemName, 0, 1, (String)null).isEmpty();
        return () -> {
            return result;
        };
    }
}
