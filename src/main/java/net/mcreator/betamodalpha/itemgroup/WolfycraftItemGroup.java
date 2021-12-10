
package net.mcreator.betamodalpha.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.betamodalpha.item.WolfiteIngotItem;
import net.mcreator.betamodalpha.BetamodAlphaModElements;

@BetamodAlphaModElements.ModElement.Tag
public class WolfycraftItemGroup extends BetamodAlphaModElements.ModElement {
	public WolfycraftItemGroup(BetamodAlphaModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwolfycraft") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(WolfiteIngotItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
