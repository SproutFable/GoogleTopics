package com.ehsankolivand.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import com.ehsankolivand.boundservice.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var activityMainBinding: ActivityMainBinding?=null

    private lateinit var  myBoundService:MyBoundService

    private var mBound: Boolean = false
    private val serviceConnection = object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyBoundService.LocalBinder
            myBoundService = binder.getService()
            mBound=  true

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding!!.root.apply {
            setContentView(this)
        }

        activityMainBinding!!.button.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        Intent(this, MyBoundService::class.java).also { intent ->
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

    }

    override fun onStop() {
        super.onStop()
        unbindService(serviceConnection)
        mBound = false
    }


    override fun onClick(v: View?) {
        if (mBound)
        activityMainBinding!!.button.text = myBoundService.randomNumber.toString()
        else
            Toast.makeText(this,"not bind",Toast.LENGTH_LONG).show()
    }


}