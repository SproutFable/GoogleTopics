package com.ehsankolivand.services

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class PlayerService: Service() {
val TAG = "SERVICE_LIFECYCLE"

    lateinit var player: MediaPlayer
    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this,Settings.System.DEFAULT_ALARM_ALERT_URI)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG,"onStartCommand")
        if (!player.isPlaying)
            player.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.i(TAG,"onStart")

    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i(TAG,"onBind")
        TODO("Not yet implemented")
    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        Log.i(TAG,"unbindService")

    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
        Log.i(TAG,"onDestroy")

    }

}