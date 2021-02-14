
package fr.jlstrykerz.mcmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.jlstrykerz.mcmod.block.PlanetAlphaGrassBlock;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;

@MinecraftmodModElements.ModElement.Tag
public class PlanetAlphaTabItemGroup extends MinecraftmodModElements.ModElement {
	public PlanetAlphaTabItemGroup(MinecraftmodModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabplanet_alpha_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlanetAlphaGrassBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
