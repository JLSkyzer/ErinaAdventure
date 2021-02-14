package fr.jlstrykerz.mcmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;

import java.util.Map;

import fr.jlstrykerz.mcmod.item.SmeltPickaxeItem;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;
import fr.jlstrykerz.mcmod.MinecraftmodMod;

@MinecraftmodModElements.ModElement.Tag
public class SmeltPickaxeRightClickedInAirProcedure extends MinecraftmodModElements.ModElement {
	public SmeltPickaxeRightClickedInAirProcedure(MinecraftmodModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MinecraftmodMod.LOGGER.warn("Failed to load dependency itemstack for procedure SmeltPickaxeRightClickedInAir!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).setDisplayName(new StringTextComponent((((new ItemStack(SmeltPickaxeItem.block, (int) (1)).getDisplayName().getString())) + ""
				+ (" + ") + "" + ("\u00A74Smelt: \u00A7e") + "" + (((itemstack).getOrCreateTag().getDouble("smelt"))))));
	}
}
