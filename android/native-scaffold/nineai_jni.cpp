#include <jni.h>
#include <mutex>

static std::mutex engine_mutex;
static bool engine_ready = false;

extern "C" JNIEXPORT jboolean JNICALL
Java_com_ninepointseven_ai_Native9AIJni_loadModel(
    JNIEnv*, jclass, jstring, jint) {
    std::lock_guard<std::mutex> lock(engine_mutex);
    engine_ready = false;
    return JNI_FALSE;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_ninepointseven_ai_Native9AIJni_generate(
    JNIEnv* env, jclass, jstring, jint) {
    std::lock_guard<std::mutex> lock(engine_mutex);
    if (!engine_ready) {
        return env->NewStringUTF("");
    }
    return env->NewStringUTF("");
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_ninepointseven_ai_Native9AIJni_release(
    JNIEnv*, jclass) {
    std::lock_guard<std::mutex> lock(engine_mutex);
    engine_ready = false;
    return JNI_TRUE;
}
