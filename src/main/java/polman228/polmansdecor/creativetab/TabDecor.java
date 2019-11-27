package polman228.polmansdecor.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import polman228.polmansdecor.PolmansDecor;

public class TabDecor extends CreativeTabs {
	public TabDecor() {
        super(PolmansDecor.MODID);
    }
 
    @SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.APPLE);
	}
}
