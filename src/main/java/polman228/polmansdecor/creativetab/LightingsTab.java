package polman228.polmansdecor.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import polman228.polmansdecor.PolmansDecor;
//import polman228.polmansdecor.init.InitBlocks;

public class LightingsTab extends CreativeTabs {
	public LightingsTab() {
        super(PolmansDecor.MODID + ".lightingsTab");
    }
 
    @SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(Blocks.REDSTONE_LAMP);
	}
}
