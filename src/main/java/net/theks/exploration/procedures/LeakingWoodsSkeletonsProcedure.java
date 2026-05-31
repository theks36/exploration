package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModItems;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LeakingWoodsSkeletonsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double rng = 0;
		if (world.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).is(ResourceLocation.parse("exploration:leaking_woods"))) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:skeletons")))) {
				if (world.dimensionType().moonPhase(world.dayTime()) == 0 && !(world instanceof Level _lvl6 && _lvl6.isDay())) {
					entity.setCustomName(Component.literal("Full Moon's Skeleton"));
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:maxhealth"), 5, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					rng = Math.random();
					if (rng <= 0.3) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack11 = new ItemStack(Items.STONE_AXE).copy();
							_setstack11.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.4) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack12 = new ItemStack(Items.IRON_AXE).copy();
							_setstack12.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack12);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.6) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack13 = new ItemStack(Items.STONE_SWORD).copy();
							_setstack13.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack13);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.65) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack14 = new ItemStack(ExplorationModItems.AMBERLINED_AXE.get()).copy();
							_setstack14.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack14);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.75) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack15 = new ItemStack(ExplorationModItems.AMBERLINED_SWORD.get()).copy();
							_setstack15.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack15);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					rng = Math.random();
					if (rng <= 0.1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.IRON_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.LEATHER_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
							}
						}
					} else if (rng <= 0.2) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_CHESTPLATE.get()));
							}
						}
					} else if (rng <= 0.25) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.LEATHER_CHESTPLATE), 30,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.LEATHER_CHESTPLATE), 30,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.LEATHER_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
							}
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack22 = new ItemStack(Items.SHIELD).copy();
							_setstack22.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack22);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.35) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(ExplorationModItems.STICKY_AMBERLINED_BOOTS_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExplorationModItems.STICKY_AMBERLINED_BOOTS_BOOTS.get()));
							}
						}
					} else if (rng <= 0.45) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.GOLDEN_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_BOOTS), 30,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.GOLDEN_BOOTS), 30,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					} else if (rng <= 0.5) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_CHESTPLATE), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.IRON_CHESTPLATE), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(ExplorationModItems.STICKY_AMBERLINED_BOOTS_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExplorationModItems.STICKY_AMBERLINED_BOOTS_BOOTS.get()));
							}
						}
					} else if (rng <= 0.7) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.LEATHER_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
							}
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack34 = new ItemStack(Items.SHIELD).copy();
							_setstack34.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack34);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.8) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.GOLDEN_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
							}
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack38 = new ItemStack(Items.SHIELD).copy();
							_setstack38.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack38);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.85) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_HELMET.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_HELMET.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_CHESTPLATE.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_CHESTPLATE.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_LEGGINGS.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_LEGGINGS.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_BOOTS.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS,
										(EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_BOOTS.get()), 45,
												(true)
														? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
														: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream())));
							}
						}
					}
				} else {
					rng = Math.random();
					if (rng <= 0.3) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack47 = new ItemStack(Items.WOODEN_SHOVEL).copy();
							_setstack47.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack47);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.4) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack48 = new ItemStack(Items.WOODEN_SWORD).copy();
							_setstack48.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack48);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.6) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack49 = new ItemStack(Items.STONE_SWORD).copy();
							_setstack49.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack49);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.65) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack50 = new ItemStack(Items.STONE_AXE).copy();
							_setstack50.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack50);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					rng = Math.random();
					if (rng <= 0.1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.LEATHER_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
							}
						}
					} else if (rng <= 0.2) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
							}
						}
					} else if (rng <= 0.25) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.LEATHER_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
							}
						}
					} else if (rng <= 0.35) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExplorationModItems.AMBERLINED_ARMOR_BOOTS.get()));
							}
						}
					} else if (rng <= 0.45) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.GOLDEN_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
							}
						}
					} else if (rng <= 0.5) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
							}
						}
					} else if (rng <= 0.55) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack58 = new ItemStack(Items.CARROT).copy();
							_setstack58.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack58);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (rng <= 0.7) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
							}
						}
					}
				}
			}
		}
	}
}