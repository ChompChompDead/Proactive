package com.chompchompdead.proactive.module

import com.chompchompdead.proactive.module.modules.RandomModule
import com.chompchompdead.proactive.module.modules.Sprint
import org.lwjgl.glfw.GLFW
import java.util.ArrayList
import java.util.stream.Collectors

object ModuleManager {

    var modules : ArrayList<Module> = ArrayList()

    init {
        modules = ArrayList()

        modules.add(Sprint)
        modules.add(RandomModule)

        println("Modules are loaded!")
    }

    fun getModulesByCategory(category : Category) : ArrayList<Module>? {
        return modules.stream().filter {
                module: Module -> module.category == category
        }.collect(Collectors.toCollection { ArrayList() })
    }

    fun toggleEvent(key : Int) {
        if (key == 0 || key == GLFW.GLFW_KEY_UNKNOWN) return

        modules.filter { it.key == key }.forEach {
            it.toggle()
        }
    }

}