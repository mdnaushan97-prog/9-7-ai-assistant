package com.ninepointseven.ai

/** JNI adapter; requires the built native library. */
object Native9AIJni {
    init {
        System.loadLibrary("nineai")
    }

    external fun loadModel(path: String, contextTokens: Int): Boolean

    external fun generate(prompt: String, maxTokens: Int): String

    external fun release(): Boolean
}
