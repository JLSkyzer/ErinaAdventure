
package fr.jlstrykerz.mcmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.jlstrykerz.mcmod.itemgroup.BloodTabItemGroup;
import fr.jlstrykerz.mcmod.MinecraftmodModElements;

@MinecraftmodModElements.ModElement.Tag
public class SabreItem extends MinecraftmodModElements.ModElement {
	@ObjectHolder("minecraftmod:sabre")
	public static final Item block = null;
	public SabreItem(MinecraftmodModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.2f, new Item.Properties().group(BloodTabItemGroup.tab)) {
		}.setRegistryName("sabre"));
	}
}
