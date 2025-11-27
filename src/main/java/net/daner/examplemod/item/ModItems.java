package net.daner.examplemod.item;

import net.daner.examplemod.Examplemod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // Create the item with its Settings
    public static final Item PINK_GARNET = register("pink_garnet");

    public static final Item RAW_PINK_GARNET = register("raw_pink_garnet");

    /*
    // Register an Item by name and Item
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Examplemod.MOD_ID, name), item);
    }
     */

    // Register an Item by name, factory and settings
    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        Identifier itemID = Identifier.of(Examplemod.MOD_ID, name);
        // Create the item instance.
        Item item = itemFactory.apply(
                settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, itemID))
        );
        // Register and return the item.
        return Registry.register(Registries.ITEM, itemID, item);
    }

    // Register a normal/default Item
    private static Item register(String name) {
        return register(name, Item::new, new Item.Settings());
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
