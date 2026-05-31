package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModItems;

import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MooniteArmorGravityProcedure {
	@SubscribeEvent
	public static void whenEntityChangeEquipment(LivingEquipmentChangeEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double total_gravity_mod = 0;
		double total_fall_distance_mod = 0;
		total_gravity_mod = -0.054;
		total_fall_distance_mod = 7;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ExplorationModItems.MOONITE_BOOTS.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:moonitebootsg"), (total_gravity_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:moonitebootsfd"), (total_fall_distance_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("exploration:moonitebootsg"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("exploration:moonitebootsfd"));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == ExplorationModItems.MOONITE_LEGGINGS.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:mooniteleggingsg"), (total_gravity_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:mooniteleggingsfd"), (total_fall_distance_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("exploration:mooniteleggingsg"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("exploration:mooniteleggingsfd"));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ExplorationModItems.MOONITE_CHESTPLATE.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:moonitechestplateg"), (total_gravity_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:moonitechestplatefd"), (total_fall_distance_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("exploration:moonitechestplateg"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("exploration:moonitechestplatefd"));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ExplorationModItems.MOONITE_HELMET.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:moonitehelmetg"), (total_gravity_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("exploration:moonitehelmetfd"), (total_fall_distance_mod / 4), AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("exploration:moonitehelmetg"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("exploration:moonitehelmetfd"));
			}
		}
	}
}