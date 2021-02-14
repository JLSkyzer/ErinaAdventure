
package fr.jlstrykerz.mcmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.jlstrykerz.mcmod.itemgroup.BloodTabItemGroup;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;

@MinecraftmodModElements.ModElement.Tag
public class CopperLiquidItem extends MinecraftmodModElements.ModElement {
	@ObjectHolder("minecraftmod:copper_liquid")
	public static final Item block = null;
	public CopperLiquidItem(MinecraftmodModElements instance) {
		super(instance, 97);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BloodTabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("copper_liquid");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
