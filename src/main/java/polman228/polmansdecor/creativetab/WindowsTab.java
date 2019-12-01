package polman228.polmansdecor.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import polman228.polmansdecor.PolmansDecor;
import polman228.polmansdecor.init.InitBlocks;

public class WindowsTab extends CreativeTabs {
	public WindowsTab() {
        super(PolmansDecor.MODID + ".windowsTab");
    }
 
    @SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(InitBlocks.white_window_quad);
	}
}
