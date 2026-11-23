package ru.donskov.cipochka.client;

import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ChickenRenderState;
import net.minecraft.resources.Identifier;
import ru.donskov.cipochka.Cipochka;
import ru.donskov.cipochka.CipochkaMod;

/** Ванильный рендерер курицы (те же модели и анимации), но с розовыми текстурами. */
public class CipochkaRenderer extends ChickenRenderer {
	private static final Identifier ADULT_TEXTURE = CipochkaMod.id("textures/entity/cipochka/cipochka.png");
	private static final Identifier BABY_TEXTURE = CipochkaMod.id("textures/entity/cipochka/cipochka_baby.png");

	public CipochkaRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	// ChickenRenderer типизирован под Chicken, а регистрации нужен рендерер для Cipochka (подкласса Chicken)
	@SuppressWarnings({"unchecked", "rawtypes"})
	static EntityRenderer<Cipochka, ?> create(EntityRendererProvider.Context context) {
		return (EntityRenderer) new CipochkaRenderer(context);
	}

	@Override
	public Identifier getTextureLocation(ChickenRenderState state) {
		return state.isBaby ? BABY_TEXTURE : ADULT_TEXTURE;
	}
}
