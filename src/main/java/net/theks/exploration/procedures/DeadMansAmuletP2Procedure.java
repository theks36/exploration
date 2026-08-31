package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModItems;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DeadMansAmuletP2Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.getType().is(EntityTypeTags.UNDEAD) && entity instanceof Player) {
			if (entity instanceof Player player4) {
				IItemHandler inventory4 = ExplorationMod.CuriosApiHelper.getCuriosInventory(player4);
				if (inventory4 != null) {
					for (int i = 0; i < inventory4.getSlots(); i++) {
						ItemStack itemstackiterator = inventory4.getStackInSlot(i);
						if (itemstackiterator.getItem() == ExplorationModItems.DEAD_MANS_AMULET.get()) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
						}
					}
				}
			}
		}
	}
}