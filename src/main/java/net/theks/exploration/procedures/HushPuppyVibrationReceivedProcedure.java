package net.theks.exploration.procedures;

import net.theks.exploration.entity.HushPuppyEntity;

import net.minecraft.world.entity.Entity;

public class HushPuppyVibrationReceivedProcedure {
	public static void execute(Entity entity, Entity sourceentity, double vibrationX, double vibrationY, double vibrationZ) {
		if (entity == null || sourceentity == null)
			return;
		if (!(sourceentity instanceof HushPuppyEntity)) {
			entity.getPersistentData().putDouble("targetX", vibrationX);
			entity.getPersistentData().putDouble("targetY", (vibrationY + 1.1));
			entity.getPersistentData().putDouble("targetZ", vibrationZ);
			entity.getPersistentData().putBoolean("heardSomething", true);
		}
	}
}