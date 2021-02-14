package fr.jlstrykerz.mcmod.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.netty.buffer.Unpooled;

import fr.jlstrykerz.mcmod.gui.PlanetTeleporterGuiGui;
import fr.jlstrykerz.mcmod.block.PlanetTeleportBaseBlock;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class PlanetTeleporterPanelOnBlockRightClickedProcedure extends MinecraftmodModElements.ModElement {
	public PlanetTeleporterPanelOnBlockRightClickedProcedure(MinecraftmodModElements instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency entity for procedure PlanetTeleporterPanelOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency x for procedure PlanetTeleporterPanelOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency y for procedure PlanetTeleporterPanelOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency z for procedure PlanetTeleporterPanelOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency world for procedure PlanetTeleporterPanelOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == PlanetTeleportBaseBlock.block.getDefaultState()
				.getBlock())
				&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == PlanetTeleportBaseBlock.block
						.getDefaultState().getBlock())
						&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == PlanetTeleportBaseBlock.block
								.getDefaultState().getBlock())
								&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1))))
										.getBlock() == PlanetTeleportBaseBlock.block.getDefaultState().getBlock())
										&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1))))
												.getBlock() == PlanetTeleportBaseBlock.block.getDefaultState().getBlock())
												&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1))))
														.getBlock() == PlanetTeleportBaseBlock.block.getDefaultState().getBlock())
														&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == PlanetTeleportBaseBlock.block.getDefaultState().getBlock())
																&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
																		.getBlock() == PlanetTeleportBaseBlock.block.getDefaultState()
																				.getBlock()))))))))) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("PlanetTeleporterGui");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new PlanetTeleporterGuiGui.GuiContainerMod(id, inventory,
									new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
