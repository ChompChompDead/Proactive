package com.chompchompdead.proactive

import com.chompchompdead.proactive.event.RenderEvent
import com.chompchompdead.proactive.module.Module
import com.chompchompdead.proactive.module.ModuleManager
import me.gavin.brimstone.Listener
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.Screen
import java.awt.Color
import java.util.*

class Gui {

    val mc : MinecraftClient = MinecraftClient.getInstance()

    @Listener
    fun onRenderOverlay(event : RenderEvent) {


        mc.textRenderer.drawWithShadow(event.matrixStack, Proactive.NAME + " v" + Proactive.VERSION, 4F, 4F, -1)

        var offset = 4

        for (module in ModuleManager.modules) {
            if (module.isEnabled()) {
                mc.textRenderer.drawWithShadow(event.matrixStack, module.name, 4F, offset.toFloat() + 11F, getRainbow())
                offset += mc.textRenderer.fontHeight
            }
        }

        ModuleManager.modules.sortWith(Comparator.comparing { module: Module -> - mc.textRenderer.getWidth(module.name) })
    }

    fun getRainbow() : Int {
        val tickColor = floatArrayOf(
            System.currentTimeMillis() % (65 * 32) / (65f * 32)
        )

        val colorRgbO: Int = Color.HSBtoRGB(tickColor[0], 1F, 1F)
        return Color(colorRgbO shr 16 and 0xFF, colorRgbO shr 8 and 0xFF, colorRgbO and 0xFF).getRGB()
    }


}