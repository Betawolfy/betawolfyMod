
package net.mcreator.betamodalpha.command;

import net.mcreator.betamodalpha.procedures.OpenMenu1Procedure;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

@Mod.EventBusSubscriber
public class OpenMenuCommand {
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(LiteralArgumentBuilder.<CommandSource>literal("openmenu")
						.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(OpenMenuCommand::execute))
						.executes(OpenMenuCommand::execute));
	}

	private static int execute(CommandContext<CommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();
		double x = ctx.getSource().getPos().getX();
		double y = ctx.getSource().getPos().getY();
		double z = ctx.getSource().getPos().getZ();
		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);
		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			OpenMenu1Procedure.executeProcedure($_dependencies);
		}
		return 0;
	}
}
