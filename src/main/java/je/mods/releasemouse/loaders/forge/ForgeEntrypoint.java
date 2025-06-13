//? if forge {
/*package je.mods.releasemouse.loaders.forge;

import je.mods.releasemouse.ReleaseMouse;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.IEventBusEngine;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLModContainer;
import org.slf4j.Logger;

@Mod("releasemouse")
public class ForgeEntrypoint {
    private static final Logger LOGGER = LogUtils.getLogger();
    public ForgeEntrypoint() {
        //LOGGER.info("Hello from ForgeEntrypoint!");
        ReleaseMouse.initialize(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
*///?}
