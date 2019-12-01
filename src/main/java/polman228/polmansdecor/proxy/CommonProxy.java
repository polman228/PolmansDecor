package polman228.polmansdecor.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import polman228.polmansdecor.init.InitBlocks;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    	InitBlocks.register(); // блоки и предметы
    }
    public void init(FMLInitializationEvent event) {
    //---.recipesRegister(); // рецепты
    }
    public void postInit(FMLPostInitializationEvent event) {}
}