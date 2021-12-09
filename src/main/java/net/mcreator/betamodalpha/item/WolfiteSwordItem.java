
package net.mcreator.betamodalpha.item;

import net.mcreator.betamodalpha.BetamodAlphaModElements;

import java.util.List;

@BetamodAlphaModElements.ModElement.Tag
public class WolfiteSwordItem extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:wolfite_sword")
	public static final Item block = null;
	public WolfiteSwordItem(BetamodAlphaModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4096;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 7f;
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
		}, 3, -2f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("L'\u00E9p\u00E9e mortelle de Wolfy."));
			}
		}.setRegistryName("wolfite_sword"));
	}
}
