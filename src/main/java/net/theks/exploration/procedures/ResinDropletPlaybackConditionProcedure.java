package net.theks.exploration.procedures;

import net.theks.exploration.entity.ResinDropletEntity;

import net.minecraft.world.entity.Entity;

public class ResinDropletPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof ResinDropletEntity _datEntI ? _datEntI.getEntityData().get(ResinDropletEntity.DATA_actionState) : 0) == 1;
	}
}