package com.ehsankolivand.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.provider.Settings

class PlayerService: Service() {
    private lateinit var media:MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         media =
            MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
       media.isLooping = true
        media.start()
        return START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
        media.stop()

    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}