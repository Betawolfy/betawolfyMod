package net.mcreator.betamodalpha.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.betamodalpha.BetamodAlphaMod;

import java.util.Map;

public class KillyourselfProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetamodAlphaMod.LOGGER.warn("Failed to load dependency entity for procedure Killyourself!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetamodAlphaMod.LOGGER.warn("Failed to load dependency x for procedure Killyourself!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetamodAlphaMod.LOGGER.warn("Failed to load dependency y for procedure Killyourself!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetamodAlphaMod.LOGGER.warn("Failed to load dependency z for procedure Killyourself!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BetamodAlphaMod.LOGGER.warn("Failed to load dependency world for procedure Killyourself!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Compris, MEURS!!"), (false));
		}
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.NONE);
		}
	}
}
