package com.moonedgestudio.cyberninjarunner

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import org.fmod.FMOD

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.moonedgestudio.cyberninjarunner/fmod"

    companion object {
        init {
            try {
                System.loadLibrary("fmod")
                System.loadLibrary("fmodstudio")
            } catch (e: UnsatisfiedLinkError) {
                android.util.Log.e("MainActivity", "Failed to pre-load FMOD native libraries: ${e.message}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            FMOD.init(this)
        } catch (e: Throwable) {
            android.util.Log.e("MainActivity", "Failed to initialize FMOD: ${e.message}")
        }
    }

    override fun onDestroy() {
        try {
            FMOD.close()
        } catch (e: Throwable) {
            android.util.Log.e("MainActivity", "Failed to close FMOD: ${e.message}")
        }
        super.onDestroy()
    }

    private var channel: MethodChannel? = null
    private var monetizationBridge: MonetizationBridge? = null

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        // Register dedicated monetization bridge
        monetizationBridge = MonetizationBridge.registerWith(this, flutterEngine.dartExecutor.binaryMessenger)

        // Existing FMOD Studio Channel - PRESERVED 100%
        channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).apply {
            setMethodCallHandler { call, result ->
                when (call.method) {
                    "initFmod" -> {
                        try {
                            FMOD.init(this@MainActivity)
                            android.util.Log.i("MainActivity", "FMOD.init(this) confirmed active")
                            result.success(true)
                        } catch (e: Throwable) {
                            android.util.Log.e("MainActivity", "FMOD.init error: ${e.message}")
                            result.error("FMOD_ERROR", e.message, null)
                        }
                    }
                    "getIntentExtra" -> {
                        val key = call.argument<String>("key")
                        result.success(intent?.getStringExtra(key))
                    }
                    else -> {
                        result.notImplemented()
                    }
                }
            }
        }
    }

    override fun onNewIntent(intent: android.content.Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        if (intent.getStringExtra("RUN_AUDIO_QA") == "true") {
            channel?.invokeMethod("runAudioQA", null)
        }
    }
}

