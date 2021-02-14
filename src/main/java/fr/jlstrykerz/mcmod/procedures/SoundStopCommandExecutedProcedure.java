package fr.jlstrykerz.mcmod.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class SoundStopCommandExecutedProcedure extends MinecraftmodModElements.ModElement {
	public SoundStopCommandExecutedProcedure(MinecraftmodModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency entity for procedure SoundStopCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						(("stopsound ") + "" + ((entity.getDisplayName().getString()))));
			}
		}
	}
}
