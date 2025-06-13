//? if fabric {
package je.mods.releasemouse.loaders.fabric;

import je.mods.releasemouse.ReleaseMouse;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class FabricEntrypoint implements ModInitializer {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from FabricEntrypoint!");
        ReleaseMouse.initialize();
    }
}
//?}
