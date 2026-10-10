package com.titaniumgear.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import com.titaniumgear.TitaniumGear;

/** Adds titanium ore veins to Windswept Gravelly Hills only. The feature JSON lives in data/titanium_gear/worldgen. */
public final class ModWorldGen {
	public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED =
			ResourceKey.create(Registries.PLACED_FEATURE, TitaniumGear.id("titanium_ore"));

	public static void initialize() {
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(Biomes.WINDSWEPT_GRAVELLY_HILLS),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				TITANIUM_ORE_PLACED);
	}

	private ModWorldGen() {
	}
}
