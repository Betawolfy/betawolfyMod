
package net.mcreator.betamodalpha.block;

import net.minecraft.block.material.Material;

import net.mcreator.betamodalpha.itemgroup.WolfycraftItemGroup;
import net.mcreator.betamodalpha.BetamodAlphaModElements;

import java.util.List;
import java.util.Collections;

@BetamodAlphaModElements.ModElement.Tag
public class TestyiumBlockBlock extends BetamodAlphaModElements.ModElement {
	@ObjectHolder("betamod_alpha:testyium_block")
	public static final Block block = null;
	public TestyiumBlockBlock(BetamodAlphaModElements instance) {
		super(instance, 94);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(WolfycraftItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 10f).setLightLevel(s -> 0).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("testyium_block");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
