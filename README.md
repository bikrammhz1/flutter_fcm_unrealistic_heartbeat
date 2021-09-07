# fcm_unrealistic_heartbeat

## Getting Started


Future<void> initFcm() async {
    String fcm;
    try {
        fcm = await FcmUnrealisticHeartbeat.init ?? 'Unknown platform version';
    } on Exception {
    fcm = 'Failed';
    }
}
