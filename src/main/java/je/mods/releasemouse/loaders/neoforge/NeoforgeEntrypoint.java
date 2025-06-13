//? if neoforge {
package je.mods.releasemouse.loaders.neoforge;

import je.mods.releasemouse.ReleaseMouse;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod("releasemouse")
public class NeoforgeEntrypoint {
    private static final Logger LOGGER = LogUtils.getLogger();

    public NeoforgeEntrypoint(IEventBus modEventBus) {
        LOGGER.info("Hello from NeoforgeEntrypoint!");
        ReleaseMouse.initialize(modEventBus);
    }
}
//?}
