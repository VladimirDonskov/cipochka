package ru.donskov.cipochka;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;

public final class ModEntities {
	public static final ResourceKey<EntityType<?>> CIPOCHKA_KEY =
			ResourceKey.create(Registries.ENTITY_TYPE, CipochkaMod.id("cipochka"));

	// Размеры, высота глаз и точка посадки наездника как у ванильной курицы
	public static final EntityType<Cipochka> CIPOCHKA = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			CIPOCHKA_KEY,
			EntityType.Builder.of(Cipochka::new, MobCategory.CREATURE)
					.sized(0.4F, 0.7F)
					.eyeHeight(0.644F)
					.passengerAttachments(new Vec3(0.0, 0.7, -0.1))
					.clientTrackingRange(10)
					.build(CIPOCHKA_KEY));

	private ModEntities() {
	}

	public static void init() {
		FabricDefaultAttributeRegistry.register(CIPOCHKA, Chicken.createAttributes());

		SpawnPlacements.register(CIPOCHKA, SpawnPlacementTypes.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

		// Спавнится в тех же биомах, что и обычные курицы, но реже
		BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityTypes.CHICKEN),
				MobCategory.CREATURE, CIPOCHKA, 3, 2, 4);
	}
}
