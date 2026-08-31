package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModItems;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DeadMansAmuletPProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(EntityTypeTags.UNDEAD) && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player player7) {
				IItemHandler inventory7 = ExplorationMod.CuriosApiHelper.getCuriosInventory(player7);
				if (inventory7 != null) {
					for (int i = 0; i < inventory7.getSlots(); i++) {
						ItemStack itemstackiterator = inventory7.getStackInSlot(i);
						if (itemstackiterator.getItem() == ExplorationModItems.DEAD_MANS_AMULET.get()) {
							if (entity instanceof Mob _entity)
								_entity.setTarget(null);
						}
					}
				}
			}
		}
	}
}