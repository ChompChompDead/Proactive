package com.chompchompdead.proactive.module

import com.chompchompdead.proactive.Proactive
import net.minecraft.client.MinecraftClient

open class Module {

    var name : String = ""
    var description : String = ""
    var key : Int = 0
    var category : Category = Category.CLIENT
    var mc : MinecraftClient = MinecraftClient.getInstance()

    private var enabled = false

    constructor(name : String, description : String, key : Int, category : Category) {
        this.name = name
        this.description = description
        this.key = key
        this.category = category
        this.enabled = false
    }

    open fun onEnable() {
        Proactive.EVENT_BUS.register(this)
    }

    open fun onDisable() {
        Proactive.EVENT_BUS.unregister(this)
    }

    open fun onUpdate() {

    }

    open fun isEnabled() : Boolean {
        return this.enabled
    }

    open fun setEnabled(enabled : Boolean) {
        if (enabled != this.enabled) {
            if (enabled) {
                onEnable()
            } else {
                onDisable()
            }
        }
        this.enabled = enabled
    }

    open fun enable() {
        enabled = true
        onEnable()
    }

    open fun toggle() {
        enabled = !enabled

        if (enabled) {
            onEnable()
        } else {
            onDisable()
        }
    }

}