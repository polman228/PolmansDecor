package polman228.polmansdecor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import polman228.polmansdecor.creativetab.TabDecor;
import polman228.polmansdecor.proxy.CommonProxy;

@Mod(modid = PolmansDecor.MODID, name = PolmansDecor.NAME, version = PolmansDecor.VERSION, acceptedMinecraftVersions = PolmansDecor.MC_VERSION)
public class PolmansDecor {

	public static final String MODID = "polmansdecor";
	public static final String NAME = "Polman's Decor";
	public static final String VERSION = "0.0.1";
	public static final String MC_VERSION = "[1.12.2]";
	public static final CreativeTabs TAB_DECOR = new TabDecor();

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
