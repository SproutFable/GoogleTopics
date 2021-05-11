package com.ehsankolivand.boundservice

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

class MyBoundService: Service() {
    private val binder = LocalBinder()
    private val random = Random()

    val randomNumber:Int
    get() = random.nextInt(100)

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    inner class LocalBinder: Binder() {
        fun getService():MyBoundService = this@MyBoundService
    }
}