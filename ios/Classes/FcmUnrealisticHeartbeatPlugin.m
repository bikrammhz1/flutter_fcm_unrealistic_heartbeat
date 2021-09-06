#import "FcmUnrealisticHeartbeatPlugin.h"
#if __has_include(<fcm_unrealistic_heartbeat/fcm_unrealistic_heartbeat-Swift.h>)
#import <fcm_unrealistic_heartbeat/fcm_unrealistic_heartbeat-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "fcm_unrealistic_heartbeat-Swift.h"
#endif

@implementation FcmUnrealisticHeartbeatPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFcmUnrealisticHeartbeatPlugin registerWithRegistrar:registrar];
}
@end
