
package net.mcreator.betamodalpha.item;

import net.mcreator.betamodalpha.BetamodAlphaModElements;

import java.util.List;

@BetamodAlphaModElements.ModElement.Tag
public class MaikoniteSwordItem extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:maikonite_sword")
	public static final Item block = null;
	public MaikoniteSwordItem(BetamodAlphaModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
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
				return Ingredient.fromStacks(new ItemStack(MaikoniteIngotItem.block));
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("L'\u00E9p\u00E9e de Maikoa"));
			}
		}.setRegistryName("maikonite_sword"));
	}
}
