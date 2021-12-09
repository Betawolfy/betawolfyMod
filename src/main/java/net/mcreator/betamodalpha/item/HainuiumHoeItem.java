
package net.mcreator.betamodalpha.item;

import net.mcreator.betamodalpha.BetamodAlphaModElements;

@BetamodAlphaModElements.ModElement.Tag
public class HainuiumHoeItem extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:hainuium_hoe")
	public static final Item block = null;
	public HainuiumHoeItem(BetamodAlphaModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(HainuiumIngotItem.block));
			}
		}, 0, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("hainuium_hoe"));
	}
}
