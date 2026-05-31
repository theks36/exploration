/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.entity.*;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class ExplorationModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ExplorationMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<ResinDropletEntity>> RESIN_DROPLET = register("resin_droplet",
			EntityType.Builder.<ResinDropletEntity>of(ResinDropletEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HushPuppyEntity>> HUSH_PUPPY = register("hush_puppy",
			EntityType.Builder.<HushPuppyEntity>of(HushPuppyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3)

					.sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<BoundSoulEntity>> BOUND_SOUL = register("bound_soul",
			EntityType.Builder.<BoundSoulEntity>of(BoundSoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MamaSpiderEntity>> MAMA_SPIDER = register("mama_spider",
			EntityType.Builder.<MamaSpiderEntity>of(MamaSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<CrystalizedZombieEntity>> CRYSTALIZED_ZOMBIE = register("crystalized_zombie",
			EntityType.Builder.<CrystalizedZombieEntity>of(CrystalizedZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<JackoEntity>> JACKO = register("jacko",
			EntityType.Builder.<JackoEntity>of(JackoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		ResinDropletEntity.init(event);
		HushPuppyEntity.init(event);
		BoundSoulEntity.init(event);
		MamaSpiderEntity.init(event);
		CrystalizedZombieEntity.init(event);
		JackoEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(RESIN_DROPLET.get(), ResinDropletEntity.createAttributes().build());
		event.put(HUSH_PUPPY.get(), HushPuppyEntity.createAttributes().build());
		event.put(BOUND_SOUL.get(), BoundSoulEntity.createAttributes().build());
		event.put(MAMA_SPIDER.get(), MamaSpiderEntity.createAttributes().build());
		event.put(CRYSTALIZED_ZOMBIE.get(), CrystalizedZombieEntity.createAttributes().build());
		event.put(JACKO.get(), JackoEntity.createAttributes().build());
	}
}