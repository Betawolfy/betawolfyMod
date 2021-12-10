
package net.mcreator.betamodalpha.item;

import net.mcreator.betamodalpha.BetamodAlphaModElements;

@BetamodAlphaModElements.ModElement.Tag
public class WolfitePickaxeItem extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:wolfite_pickaxe")
	public static final Item block = null;
	public WolfitePickaxeItem(BetamodAlphaModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4096;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(WolfiteIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("wolfite_pickaxe"));
	}
}
