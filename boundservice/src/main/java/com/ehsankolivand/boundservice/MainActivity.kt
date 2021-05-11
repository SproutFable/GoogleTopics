package com.ehsankolivand.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.ehsankolivand.boundservice.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private var activityMainBinding: ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding!!.root.apply {
            setContentView(this)
        }

    }




}