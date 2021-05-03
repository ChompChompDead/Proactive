package com.chompchompdead.proactive.module.modules

import com.chompchompdead.proactive.module.Category
import com.chompchompdead.proactive.module.Module
import org.lwjgl.glfw.GLFW

object Sprint : Module("Sprint", "sprint fast like cool boy", GLFW.GLFW_KEY_C, Category.MOVEMENT) {

    override fun onUpdate() {
        if (mc.player != null) {
            mc.player!!.isSprinting = true
            println("Sussy")
        }
    }

}