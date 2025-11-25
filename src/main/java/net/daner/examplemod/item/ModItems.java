package net.daner.examplemod.item;

import net.daner.examplemod.Examplemod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Create the item with its Settings
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Examplemod.MOD_ID,"pink_garnet")))));

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Examplemod.MOD_ID,"raw_pink_garnet")))));

    // Register an Item by name and Item
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Examplemod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Examplemod.LOGGER.info("Registering Mod Items for " + Examplemod.MOD_ID);

        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
        */

    }
}
