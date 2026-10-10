package com.titaniumgear.block;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.titaniumgear.TitaniumGear;

public class ModBlocks {
	public static final Block TITANIUM_ORE = registerWithItem(
			"titanium_ore",
			properties -> new DropExperienceBlock(UniformInt.of(1, 4), properties),
			BlockBehaviour.Properties.of()
					.strength(3.0F, 3.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.STONE)
	);

	private static Block registerWithItem(String name, Function<BlockBehaviour.Properties, Block> factory,
			BlockBehaviour.Properties properties) {
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, TitaniumGear.id(name));
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, TitaniumGear.id(name));

		Block block = factory.apply(properties.setId(blockKey));
		Registry.register(BuiltInRegistries.BLOCK, blockKey, block);

		BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

		return block;
	}

	public static void initialize() {
	}
}
