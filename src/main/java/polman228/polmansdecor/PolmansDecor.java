package polman228.polmansdecor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import polman228.polmansdecor.creativetab.LightingsTab;
import polman228.polmansdecor.creativetab.WindowsTab;
import polman228.polmansdecor.proxy.CommonProxy;

@Mod(modid = PolmansDecor.MODID, name = PolmansDecor.NAME, version = PolmansDecor.VERSION, acceptedMinecraftVersions = PolmansDecor.MCVERSION)
public class PolmansDecor {

	public static final String MODID = "polmansdecor";
	public static final String NAME = "Polman's Decor";
	public static final String VERSION = "@VERSION@";
	public static final String MCVERSION = "@MCVERSION@";
	public static final CreativeTabs WINDOWS_TAB = new WindowsTab();
	//public static final CreativeTabs LIGHTINGS_TAB = new LightingsTab();

	@SidedProxy(clientSide = "polman228.polmansdecor.proxy.ClientProxy", serverSide = "polman228.polmansdecor.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}
