package com.titaniumgear;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

import com.titaniumgear.block.ModBlocks;
import com.titaniumgear.item.ModItems;
import com.titaniumgear.world.ModWorldGen;

public class TitaniumGear implements ModInitializer {
	public static final String MOD_ID = "titanium_gear";

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
		ModWorldGen.initialize();
	}
}
