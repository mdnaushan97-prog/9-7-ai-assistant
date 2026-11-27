package com.ninepointseven.ai

import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import com.getcapacitor.JSObject

@CapacitorPlugin(name = "Native9AI")
class Native9AIPlugin : Plugin() {

    @PluginMethod
    fun status(call: PluginCall) {
        call.resolve(
            JSObject().put("status", "unavailable")
        )
    }

    @PluginMethod
    fun load(call: PluginCall) {
        val path = call.getString("path")

        if (path.isNullOrBlank()) {
            call.reject("Model path missing")
            return
        }

        call.reject("Native runtime is not connected yet")
    }

    @PluginMethod
    fun generate(call: PluginCall) {
        call.reject("Offline AI model is not loaded")
    }

    @PluginMethod
    fun unload(call: PluginCall) {
        call.resolve()
    }
}
