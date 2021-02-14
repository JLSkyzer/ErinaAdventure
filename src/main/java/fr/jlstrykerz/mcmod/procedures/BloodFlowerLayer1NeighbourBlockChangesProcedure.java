package fr.jlstrykerz.mcmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;

import java.util.Map;

import fr.jlstrykerz.mcmod.block.PlantAutomationBlock;
import fr.jlstrykerz.mcmod.block.BloodDirtBlock;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class BloodFlowerLayer1NeighbourBlockChangesProcedure extends MinecraftmodModElements.ModElement {
	public BloodFlowerLayer1NeighbourBlockChangesProcedure(MinecraftmodModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency x for procedure BloodFlowerLayer1NeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency y for procedure BloodFlowerLayer1NeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency z for procedure BloodFlowerLayer1NeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency world for procedure BloodFlowerLayer1NeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BloodDirtBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == PlantAutomationBlock.block.getDefaultState()
						.getBlock())))) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}
