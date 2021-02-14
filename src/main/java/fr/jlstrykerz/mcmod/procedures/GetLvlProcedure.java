package fr.jlstrykerz.mcmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.jlstrykerz.mcmod.MinecraftmodModVariables;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class GetLvlProcedure extends MinecraftmodModElements.ModElement {
	public GetLvlProcedure(MinecraftmodModElements instance) {
		super(instance, 68);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency entity for procedure GetLvl!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A76????? \u00A7aNiveau \u00A76?????"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
					(("\u00A7aVous etes niveau: \u00A7e") + "" + (((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MinecraftmodModVariables.PlayerVariables())).lvl)))),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
					(("\u00A7aXp: \u00A7e") + "" + (((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MinecraftmodModVariables.PlayerVariables())).xp)) + "" + (" / 10.000"))),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((("\u00A7c%???% \u00A7e") + ""
							+ (((((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MinecraftmodModVariables.PlayerVariables())).xp) * 100) / 10000))
							+ "" + (" \u00A7c%???%"))),
					(false));
		}
	}
}
