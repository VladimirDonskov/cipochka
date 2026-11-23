package ru.donskov.cipochka;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.animal.chicken.ChickenVariants;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jspecify.annotations.Nullable;

/**
 * Цыпочка: обычная курица во всём, кроме типа сущности и текстуры.
 * Вариант всегда "temperate", чтобы рендерилась стандартная модель курицы
 * (у холодного варианта модель другая).
 */
public class Cipochka extends Chicken {
	public Cipochka(EntityType<? extends Cipochka> type, Level level) {
		super(type, level);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
			EntitySpawnReason reason, @Nullable SpawnGroupData groupData) {
		SpawnGroupData result = super.finalizeSpawn(level, difficulty, reason, groupData);
		useTemperateVariant(level.registryAccess());
		return result;
	}

	@Override
	public @Nullable Chicken getBreedOffspring(ServerLevel level, AgeableMob partner) {
		Cipochka baby = ModEntities.CIPOCHKA.create(level, EntitySpawnReason.BREEDING);
		if (baby != null) {
			baby.useTemperateVariant(level.registryAccess());
		}
		return baby;
	}

	private void useTemperateVariant(RegistryAccess registries) {
		registries.lookupOrThrow(Registries.CHICKEN_VARIANT)
				.get(ChickenVariants.TEMPERATE)
				.ifPresent(this::setVariant);
	}
}
