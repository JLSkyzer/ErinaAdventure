package fr.jlstrykerz.mcmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import fr.jlstrykerz.mcmod.MinecraftmodModVariables;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class XpCommandExecutedProcedure extends MinecraftmodModElements.ModElement {
	public XpCommandExecutedProcedure(MinecraftmodModElements instance) {
		super(instance, 71);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency entity for procedure XpCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency cmdparams for procedure XpCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("give"))) {
			{
				double _setval = (double) (((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MinecraftmodModVariables.PlayerVariables())).xp) + new Object() {
							int convert(String s) {
								try {
									return Integer.parseInt(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("1");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())));
				entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("take"))) {
			{
				double _setval = (double) (((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MinecraftmodModVariables.PlayerVariables())).xp) - new Object() {
							int convert(String s) {
								try {
									return Integer.parseInt(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("1");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())));
				entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("set"))) {
			{
				double _setval = (double) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
				entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7l\u00A7cVeuillez executez la commandes avec cet usage:"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e/ErinaXp give <number>"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e/ErinaXp take <number>"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e/ErinaXp set <number>"), (false));
			}
		}
	}
}
