package je.mods.releasemouse;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.logging.LogUtils;
//? if fabric {
/*import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
*///?}
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
//? if neoforge {
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;
//?} else if forge {
/*import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
*///?}
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
//? if neoforge || forge {
@Mod(ReleaseMouse.MODID)
//?}
public class ReleaseMouse {
    public static final String MODID = "releasemouse";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static KeyMapping KEY;
    private static boolean KeyDown = false;
    //? if fabric {
    /*public static void initialize() {
    *///?} else if neoforge || forge {
    public static void initialize(IEventBus modEventBus) {
    //?}
        //? if fabric {
        /*// 注册按键绑定
        KEY = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.releasemouse.release_mouse",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,// 默认按键：G
                "category.releasemouse"
        ));
        // new code
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            if (KEY.isDown() && !KeyDown) {
                client.mouseHandler.releaseMouse();
                KeyDown = true;
            } else if (!KEY.isDown() && KeyDown) {
                client.mouseHandler.grabMouse();
                KeyDown = false;
            }
        });


        *///?}
        //? if neoforge {
        // 注册按键
        modEventBus.addListener(ReleaseMouse::onRegisterKeyMappings);
        // 注册事件
        NeoForge.EVENT_BUS.addListener(ReleaseMouse::onClientTick);
        //?} elif forge {
        /*MinecraftForge.EVENT_BUS.addListener(ReleaseMouse::onClientTick);
        modEventBus.addListener(ReleaseMouse::onRegisterKeyMappings);
        *///?}
    }
    //? if neoforge || forge {
    private static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        // 创建按键
        KEY = new KeyMapping(
                "key.releasemouse.release_mouse",
                GLFW.GLFW_KEY_LEFT_ALT, // 默认按键
                "key.category.releasemouse"
        );
        event.register(KEY);
    }
    //?}

    //? if neoforge {
    private static void onClientTick(ClientTickEvent.Post event) {
    //?} else if forge {
    /*private static void onClientTick(ClientTickEvent event) {
    *///?}
    //? if forge || neoforge {
        if (KEY == null) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        if (KEY.isDown() && !KeyDown) {
            mc.mouseHandler.releaseMouse();
            KeyDown = true;
        } else if (!KEY.isDown() && KeyDown) {
            mc.mouseHandler.grabMouse();
            KeyDown = false;
        }
    }
    //?}
}
