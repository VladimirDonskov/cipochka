package ru.donskov.cipochka;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class CipochkaMod implements ModInitializer {
	public static final String MOD_ID = "cipochka";

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModEntities.init();
		ModItems.init();
	}
}
