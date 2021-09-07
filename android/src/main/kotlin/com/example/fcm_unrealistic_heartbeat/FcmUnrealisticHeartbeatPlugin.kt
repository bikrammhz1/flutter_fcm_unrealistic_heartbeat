package com.example.fcm_unrealistic_heartbeat

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.PluginRegistry.Registrar
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import android.content.Context
import android.app.Activity
/** FcmUnrealisticHeartbeatPlugin */
class FcmUnrealisticHeartbeatPlugin : FlutterPlugin, MethodCallHandler,ActivityAware {
    private lateinit var channel: MethodChannel
    private lateinit var context: Context

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "fcm_unrealistic_heartbeat")
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "getUnrealisticHeartbeat") {
            var gcmKeepAlive = GcmKeepAlive(context)
            gcmKeepAlive.broadcastIntents()
            result.success("Sending heart beat to keep gcm alive on Android ${android.os.Build.VERSION.RELEASE}")
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    override fun onDetachedFromActivity() {}

    override fun onReattachedToActivityForConfigChanges(@NonNull binding: ActivityPluginBinding) {}

    override fun onAttachedToActivity(@NonNull binding: ActivityPluginBinding) {
        context = binding.getActivity()
    }

    override fun onDetachedFromActivityForConfigChanges() {}
}
