package ru.donskov.cipochka.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import ru.donskov.cipochka.ModEntities;

public class CipochkaModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.CIPOCHKA, CipochkaRenderer::create);
	}
}
