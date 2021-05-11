package com.ehsankolivand.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val state = intent?.getBooleanExtra("state",false) ?:return
        Toast.makeText(context,"BroadCast Receive",Toast.LENGTH_LONG).show()
    }
}