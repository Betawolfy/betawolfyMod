
package net.mcreator.betamodalpha.item;

import net.mcreator.betamodalpha.BetamodAlphaModElements;

@BetamodAlphaModElements.ModElement.Tag
public class FriesItem extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:fries")
	public static final Item block = null;
	public FriesItem(BetamodAlphaModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(12).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(8).saturation(0.3f).build()));
			setRegistryName("fries");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
