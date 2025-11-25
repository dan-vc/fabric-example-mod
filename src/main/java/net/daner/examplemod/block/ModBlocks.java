package net.daner.examplemod.block;

import net.daner.examplemod.Examplemod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // Create the block with its settings
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Examplemod.MOD_ID,"pink_garnet_block")))));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Examplemod.MOD_ID,"raw_pink_garnet_block")))));

    // Register the block Itself with Registry
    private static Block registerBlock(String name, Block block){
        // Register the Item of the Block
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Examplemod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Examplemod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Examplemod.MOD_ID,name)))));
    }

    public static void registerModBlocks(){
        Examplemod.LOGGER.info("Registering Mod Blocks for " + Examplemod.MOD_ID);

        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
        });
         */
    }
}
