package net.daner.examplemod.block;

import net.daner.examplemod.Examplemod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {

    // Create the block with its settings
    public static final Block PINK_GARNET_BLOCK = registerBlock(
            "pink_garnet_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .luminance(s -> 15)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    );
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock(
            "raw_pink_garnet_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    );

    public static final Block PINK_GARNET_ORE = registerBlock(
            "pink_garnet_ore",
            settings -> new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
                    settings
            ),
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    );
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock(
            "pink_garnet_deepslate_ore",
            settings -> new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    settings
            ),
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    );

    public static final Block COMPACTOR_BLOCK = registerBlock(
            "compactor_block",
            CompactorBlock::new,
            AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
    );

    /*
    // Register the block Itself with Registry
    private static Block registerBlock(String name, Block block){
        // Register the Item of the Block
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Examplemod.MOD_ID, name), block);
    }
    */
    /*
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Examplemod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Examplemod.MOD_ID,name)))));
    }
     */

    // Register the block Itself with Registry
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings){
        // Create the block key.
        Identifier blockID = Identifier.of(Examplemod.MOD_ID, name);
        // Create the Block instance with factory.
        Block block = blockFactory.apply(
                settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, blockID))
        );
        // Register the BlockItem.
        registerBlockItem(name, block);
        // Register and return the block
        return Registry.register(Registries.BLOCK, blockID, block);
    }

    private static BlockItem registerBlockItem(String name, Block block) {
        // Create the item key.
        Identifier id = Identifier.of(Examplemod.MOD_ID, name);
        // Create the item settings
        Item.Settings settings = new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id));
        // Create the item instance
        BlockItem blockItem = new BlockItem(block, settings);
        // Register and the item
        return Registry.register(Registries.ITEM, id, blockItem);
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
