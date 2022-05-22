package me.preciouso.coorddispplay;

import com.mojang.logging.LogUtils;
import me.preciouso.coorddispplay.overlays.CoordOverlay;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static me.preciouso.coorddispplay.CoordDisplay.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class CoordDisplay {
    public static final String MOD_ID = "coorddisplay";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CoordDisplay() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);


    }

    @SubscribeEvent
    public void init(FMLClientSetupEvent event) {
        LOGGER.info("Registering overlays");
        OverlayRegistry.registerOverlayAbove(ForgeIngameGui.CROSSHAIR_ELEMENT, "Coord Overlay", CoordOverlay.HUD_COORDS);

    }

}
