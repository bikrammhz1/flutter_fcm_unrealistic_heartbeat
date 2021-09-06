import Flutter
import UIKit

public class SwiftFcmUnrealisticHeartbeatPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "fcm_unrealistic_heartbeat", binaryMessenger: registrar.messenger())
    let instance = SwiftFcmUnrealisticHeartbeatPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("iOS " + UIDevice.current.systemVersion)
  }
}
