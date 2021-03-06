
package net.mcreator.betamodalpha.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.betamodalpha.BetamodAlphaModElements;

import java.util.List;

@BetamodAlphaModElements.ModElement.Tag
public class BowlOfRizItem extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:bowl_of_riz")
	public static final Item block = null;
	public BowlOfRizItem(BetamodAlphaModElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(8f).build()));
			setRegistryName("bowl_of_riz");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("vous \u00EAtes sur que ce n'est pas autre chose?  comme..."));
		}
	}
}
