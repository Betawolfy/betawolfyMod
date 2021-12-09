package net.mcreator.betamodalpha.procedures;

import net.mcreator.betamodalpha.BetamodAlphaMod;

import java.util.Map;

public class RedirectMiseAJourProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetamodAlphaMod.LOGGER.warn("Failed to load dependency entity for procedure RedirectMiseAJour!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("voici la page pour \u00EAtre au courant de tout!"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("https://gitlab.com/betawolfy/wolfymod/-/wikis/mise-\u00E0-jour"),
					(false));
		}
	}
}
