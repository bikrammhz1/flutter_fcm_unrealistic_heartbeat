package com.example.fcm_unrealistic_heartbeat

import android.content.Context
import android.content.Intent
import android.os.CountDownTimer

public class GcmKeepAlive(var mContext: Context) {
  protected var timer: CountDownTimer? = null
  protected var gTalkHeartBeatIntent: Intent
  protected var mcsHeartBeatIntent: Intent

  fun broadcastIntents() {
    println("sending heart beat to keep gcm alive")
    mContext.sendBroadcast(gTalkHeartBeatIntent)
    mContext.sendBroadcast(mcsHeartBeatIntent)
  }

  init {
    gTalkHeartBeatIntent = Intent(
      "com.google.android.intent.action.GTALK_HEARTBEAT"
    )
    mcsHeartBeatIntent = Intent(
      "com.google.android.intent.action.MCS_HEARTBEAT"
    )
  }
}