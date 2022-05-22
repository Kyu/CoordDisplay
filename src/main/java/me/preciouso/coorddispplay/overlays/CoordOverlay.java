package me.preciouso.coorddispplay.overlays;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.gui.IIngameOverlay;

import java.util.Locale;

public class CoordOverlay {

    public static String getXZDirection(double yRot) {
        // get x-z direction (+ or -) from y rotation value
        boolean x_neg = false, z_neg = false;

        if (yRot > 0.0D && yRot < 180.0D) {
            x_neg = true;
        }
        if (yRot > 90.0D || yRot < -90.0D) {
            z_neg = true;
        }
        String x_dir = x_neg ? "-" : "+";
        String z_dir = z_neg ? "-" : "+";

        return x_dir + "X, " + z_dir + "Z";
    }

    public static final IIngameOverlay HUD_COORDS = (gui, poseStack, partialTicks, width, height) -> {
        Minecraft mc = Minecraft.getInstance();
        Entity camera = mc.cameraEntity;

        if (mc.player != null && !mc.options.renderDebug && camera != null) { // F3 enabled
            double x = camera.getX(), y = camera.getY(), z = camera.getZ();
            String loc = String.format(Locale.ROOT, "XYZ: %.1f / %.1f / %.1f", x, y, z);
            String dir = "Facing: " + getXZDirection(Mth.wrapDegrees(camera.getYRot()));

            gui.getFont().draw(poseStack, loc, 10, 10, 0xffffffff);
            gui.getFont().draw(poseStack, dir, 10, 20, 0xffffffff);

        }
    };
}
