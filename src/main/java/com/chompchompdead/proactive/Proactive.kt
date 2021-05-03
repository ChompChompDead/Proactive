package com.chompchompdead.proactive

import me.gavin.brimstone.EventBus
import net.fabricmc.api.ModInitializer

class Proactive : ModInitializer {

    companion object {
        val NAME = "Proactive"
        val VERSION = "0.0.1"

        @JvmField
        val EVENT_BUS = EventBus()
    }

    override fun onInitialize() {
        EVENT_BUS.register(Gui())
        println(NAME + " v" + VERSION + "is loaded!")
    }

}