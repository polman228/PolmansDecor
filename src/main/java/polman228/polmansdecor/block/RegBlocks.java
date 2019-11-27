package polman228.polmansdecor.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import polman228.polmansdecor.bases.BaseWindowQuad;

public class RegBlocks {
	
	public static Block white_window_quad = new BaseWindowQuad("white_window_quad");

	public static void register() {
		registerBlock(white_window_quad);
	}
	public static void registerRender() {
		registerRenderBlock(white_window_quad);
	}
	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	public static void registerRenderBlock(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}