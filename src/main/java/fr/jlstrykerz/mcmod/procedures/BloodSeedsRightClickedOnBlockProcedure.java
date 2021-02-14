package fr.jlstrykerz.mcmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import fr.jlstrykerz.mcmod.item.BloodSeedsItem;
import fr.jlstrykerz.mcmod.block.BloodFlowerLayer1Block;
import fr.jlstrykerz.mcmod.block.BloodDirtBlock;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class BloodSeedsRightClickedOnBlockProcedure extends MinecraftmodModElements.ModElement {
	public BloodSeedsRightClickedOnBlockProcedure(MinecraftmodModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency entity for procedure BloodSeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency x for procedure BloodSeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency y for procedure BloodSeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency z for procedure BloodSeedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency world for procedure BloodSeedsRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BloodDirtBlock.block.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BloodFlowerLayer1Block.block.getDefaultState(), 3);
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(BloodSeedsItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
		}
	}
}
