package fr.jlstrykerz.mcmod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import fr.jlstrykerz.mcmod.MinecraftmodModVariables;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class OnWonLvlProcedure extends MinecraftmodModElements.ModElement {
	public OnWonLvlProcedure(MinecraftmodModElements instance) {
		super(instance, 69);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency entity for procedure OnWonLvl!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency world for procedure OnWonLvl!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MinecraftmodModVariables.PlayerVariables())).xp) >= 10000)) {
			{
				double _setval = (double) 0;
				entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MinecraftmodModVariables.PlayerVariables())).lvl) + 1);
				entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("\u00A76????? \u00A7aNiveau \u00A76?????"), ChatType.SYSTEM,
							Util.DUMMY_UUID);
			}
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent((("\u00A75") + "" + ((entity.getDisplayName().getString())) + ""
									+ (" \u00A7eVient d'augmenter de niveau ! il est mainenant niveau \u00A7a ") + ""
									+ (((entity.getCapability(MinecraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MinecraftmodModVariables.PlayerVariables())).lvl))
									+ "" + (" \u00A7eDites lui \u00A7bGG"))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
