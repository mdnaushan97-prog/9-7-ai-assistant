# 9.7 AI — Offline Engine Implementation Specification

## Scope
Run text generation entirely on Android after model setup.

## Proposed backend
- Kotlin plugin connected to llama.cpp via JNI, using a GGUF model.
- Select a small quantized model only after checking device RAM and storage.
- Store model files in app-private storage.
- Inference should not require network permission.

## Bridge contract
- status() reports ready only when the model is loaded.
- generate(prompt) rejects when model is unloaded or fails.
- Never return fake AI responses.
- unload() releases native resources.

## Milestones
1. Export web source and verify Capacitor shell.
2. Add Kotlin plugin and bridge registration.
3. Build llama.cpp Android libraries and link JNI.
4. Import a compatible GGUF model.
5. Implement inference and error handling.
6. Test on-device including airplane mode.

## Status
Scaffold only. Native build and device validation remain undone.
