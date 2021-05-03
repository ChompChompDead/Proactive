package com.chompchompdead.proactive.module


@Retention(AnnotationRetention.RUNTIME)
annotation class ProactiveModule(val name : String, val description : String, val key : Int, val category : Category)
