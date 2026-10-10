package com.titaniumgear.item;

import java.util.Map;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.Block;

import com.titaniumgear.TitaniumGear;

public final class TitaniumMaterials {
	/** Diamond is 33, netherite is 37. */
	public static final int ARMOR_BASE_DURABILITY = 38;

	public static final ResourceKey<EquipmentAsset> ARMOR_ASSET =
			ResourceKey.create(EquipmentAssets.ROOT_ID, TitaniumGear.id("titanium"));

	/** Items that repair titanium gear (see data/titanium_gear/tags/item/repairs_titanium.json). */
	public static final TagKey<Item> REPAIRS_TITANIUM =
			TagKey.create(Registries.ITEM, TitaniumGear.id("repairs_titanium"));

	public static final TagKey<Block> INCORRECT_FOR_TITANIUM_TOOL =
			TagKey.create(Registries.BLOCK, TitaniumGear.id("incorrect_for_titanium_tool"));

	public static final ArmorMaterial ARMOR = new ArmorMaterial(
			ARMOR_BASE_DURABILITY,
			Map.of(
					ArmorType.HELMET, 3,
					ArmorType.CHESTPLATE, 8,
					ArmorType.LEGGINGS, 6,
					ArmorType.BOOTS, 3
			),
			15,                                   // enchantability
			SoundEvents.ARMOR_EQUIP_NETHERITE,    // equip sound
			2.5F,                                 // toughness
			0.05F,                                // knockback resistance
			REPAIRS_TITANIUM,
			ARMOR_ASSET
	);

	public static final ToolMaterial TOOL = new ToolMaterial(
			INCORRECT_FOR_TITANIUM_TOOL,
			1900,   // durability (diamond 1561, netherite 2031)
			8.5F,   // mining speed
			3.5F,   // attack damage bonus
			15,     // enchantability
			REPAIRS_TITANIUM
	);

	private TitaniumMaterials() {
	}
}
