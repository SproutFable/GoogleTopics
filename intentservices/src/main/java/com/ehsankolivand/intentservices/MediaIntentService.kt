package com.ehsankolivand.intentservices

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import java.lang.Exception

class MediaIntentService : IntentService("mediaPlayer") {


    private lateinit var media:MediaPlayer
    init {
        INSTANCE = this
    }
    companion object{
        private lateinit var INSTANCE:MediaIntentService
        var isRunning = false

        fun stop()
        {
            if (isRunning){
                isRunning=false
                INSTANCE.stopSelf()
            }


        }
    }

    override fun onHandleIntent(intent: Intent?) {


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true
        media = MediaPlayer.create(this,Settings.System.DEFAULT_ALARM_ALERT_URI)
        media.start()
        return START_STICKY
    }


    override fun stopService(name: Intent?): Boolean {

            media.stop()

        return super.stopService(name)
    }



}