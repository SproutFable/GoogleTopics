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

    private lateinit var  myBoundService:MyBoundService

    private var mBound: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding!!.root.apply {
            setContentView(this)
        }



    }

    override fun onStart() {
        super.onStart()

        bindService(Intent(this,MyBoundService::class.java)
            ,serviceConnection,Context.BIND_AUTO_CREATE)

    }
    val serviceConnection = object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyBoundService.LocalBinder
            myBoundService = binder.getService()
            mBound=  true

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }

    }
}