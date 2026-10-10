package com.titaniumgear.item;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;

import com.titaniumgear.TitaniumGear;

public class ModItems {
	// --- materials
	public static final Item RAW_TITANIUM = register("raw_titanium", Item::new, new Item.Properties());
	public static final Item TITANIUM_INGOT = register("titanium_ingot", Item::new, new Item.Properties());

	// --- armor
	public static final Item TITANIUM_HELMET = register("titanium_helmet", Item::new, new Item.Properties()
			.humanoidArmor(TitaniumMaterials.ARMOR, ArmorType.HELMET)
			.durability(ArmorType.HELMET.getDurability(TitaniumMaterials.ARMOR_BASE_DURABILITY)));
	public static final Item TITANIUM_CHESTPLATE = register("titanium_chestplate", Item::new, new Item.Properties()
			.humanoidArmor(TitaniumMaterials.ARMOR, ArmorType.CHESTPLATE)
			.durability(ArmorType.CHESTPLATE.getDurability(TitaniumMaterials.ARMOR_BASE_DURABILITY)));
	public static final Item TITANIUM_LEGGINGS = register("titanium_leggings", Item::new, new Item.Properties()
			.humanoidArmor(TitaniumMaterials.ARMOR, ArmorType.LEGGINGS)
			.durability(ArmorType.LEGGINGS.getDurability(TitaniumMaterials.ARMOR_BASE_DURABILITY)));
	public static final Item TITANIUM_BOOTS = register("titanium_boots", Item::new, new Item.Properties()
			.humanoidArmor(TitaniumMaterials.ARMOR, ArmorType.BOOTS)
			.durability(ArmorType.BOOTS.getDurability(TitaniumMaterials.ARMOR_BASE_DURABILITY)));

	// --- tools (damage/speed values follow the vanilla pattern; material bonus is added on top)
	public static final Item TITANIUM_SWORD = register("titanium_sword", Item::new,
			new Item.Properties().sword(TitaniumMaterials.TOOL, 3.0F, -2.4F));
	public static final Item TITANIUM_PICKAXE = register("titanium_pickaxe", Item::new,
			new Item.Properties().pickaxe(TitaniumMaterials.TOOL, 1.0F, -2.8F));
	public static final Item TITANIUM_AXE = register("titanium_axe", Item::new,
			new Item.Properties().axe(TitaniumMaterials.TOOL, 5.0F, -3.0F));
	public static final Item TITANIUM_SHOVEL = register("titanium_shovel", Item::new,
			new Item.Properties().shovel(TitaniumMaterials.TOOL, 1.5F, -3.0F));
	public static final Item TITANIUM_HOE = register("titanium_hoe", Item::new,
			new Item.Properties().hoe(TitaniumMaterials.TOOL, -3.5F, 0.0F));

	// --- mace (vanilla MaceItem gives the smash attack; vanilla mace: 500 durability, 5 damage, -3.4 speed)
	public static final Item TITANIUM_MACE = register("titanium_mace", MaceItem::new, new Item.Properties()
			.rarity(Rarity.RARE)
			.durability(750)
			.component(DataComponents.TOOL, MaceItem.createToolProperties())
			.attributes(ItemAttributeModifiers.builder()
					.add(Attributes.ATTACK_DAMAGE,
							new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 6.0, AttributeModifier.Operation.ADD_VALUE),
							EquipmentSlotGroup.MAINHAND)
					.add(Attributes.ATTACK_SPEED,
							new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -3.3, AttributeModifier.Operation.ADD_VALUE),
							EquipmentSlotGroup.MAINHAND)
					.build())
			.enchantable(15)
			.repairable(TitaniumMaterials.REPAIRS_TITANIUM));

	private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, TitaniumGear.id(name));
		Item item = factory.apply(settings.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(tab -> {
			tab.accept(RAW_TITANIUM);
			tab.accept(TITANIUM_INGOT);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
				.register(tab -> tab.accept(com.titaniumgear.block.ModBlocks.TITANIUM_ORE.asItem()));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(tab -> {
			tab.accept(TITANIUM_HELMET);
			tab.accept(TITANIUM_CHESTPLATE);
			tab.accept(TITANIUM_LEGGINGS);
			tab.accept(TITANIUM_BOOTS);
			tab.accept(TITANIUM_SWORD);
			tab.accept(TITANIUM_AXE);
			tab.accept(TITANIUM_MACE);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(tab -> {
			tab.accept(TITANIUM_SHOVEL);
			tab.accept(TITANIUM_PICKAXE);
			tab.accept(TITANIUM_AXE);
			tab.accept(TITANIUM_HOE);
		});
	}
}
