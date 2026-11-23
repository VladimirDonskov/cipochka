package ru.donskov.cipochka;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;

public final class ModItems {
	public static final ResourceKey<Item> CIPOCHKA_SPAWN_EGG_KEY =
			ResourceKey.create(Registries.ITEM, CipochkaMod.id("cipochka_spawn_egg"));

	public static final Item CIPOCHKA_SPAWN_EGG = Registry.register(
			BuiltInRegistries.ITEM,
			CIPOCHKA_SPAWN_EGG_KEY,
			new SpawnEggItem(new Item.Properties()
					.setId(CIPOCHKA_SPAWN_EGG_KEY)
					.spawnEgg(ModEntities.CIPOCHKA)));

	private ModItems() {
	}

	public static void init() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS)
				.register(output -> output.insertAfter(Items.CHICKEN_SPAWN_EGG, CIPOCHKA_SPAWN_EGG));
	}
}
