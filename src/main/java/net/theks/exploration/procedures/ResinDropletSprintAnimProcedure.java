package net.mcreator.diddyblud.procedures;

import net.minecraft.world.entity.Entity;

public class ResinDropletSprintAnimProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.isSprinting();
	}
}