package net.theks.exploration.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class DimensionCMDpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double safeY = 0;
		double og_x = 0;
		double og_y = 0;
		double og_z = 0;
		String og_dimension = "";
		boolean found_safe_spot = false;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "target")) {
				found_safe_spot = false;
				og_dimension = "" + entity.level().dimension();
				if (BoolArgumentType.getBool(arguments, "surface")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as " + entityiterator.getDisplayName().getString() + " at @s in " + StringArgumentType.getString(arguments, "dimension") + " run tp @s ~ "
										+ world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) + " ~"));
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as " + entityiterator.getDisplayName().getString() + " at @s in " + StringArgumentType.getString(arguments, "dimension") + " run tp @s ~ ~ ~"));
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}