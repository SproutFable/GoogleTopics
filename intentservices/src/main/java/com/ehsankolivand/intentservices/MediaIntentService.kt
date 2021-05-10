package com.ehsankolivand.intentservices

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import java.lang.Exception

class MediaIntentService private constructor(name: String?): IntentService(name) {

    private lateinit var media:MediaPlayer
    companion object{
        var INSTANCE:MediaIntentService?=null
        var isRunning = false

        fun newInstance() = synchronized(this){
            if (INSTANCE==null)
                INSTANCE = MediaIntentService("mediaPlayer")
            INSTANCE
        }
        fun stop()
        {
            if (isRunning){
                INSTANCE?.stopSelf()
                isRunning=false
            }


        }
    }

    override fun onHandleIntent(intent: Intent?) {
        isRunning = true
        media = MediaPlayer.create(this,Settings.System.DEFAULT_ALARM_ALERT_URI)
        media.start()

    }

    override fun stopService(name: Intent?): Boolean {
        if (isRunning)
        {
            media.stop()
        }
        return super.stopService(name)
    }

}