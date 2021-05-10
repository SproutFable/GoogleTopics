package com.ehsankolivand.intentservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ehsankolivand.intentservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var activityMainBinding: ActivityMainBinding?=null
    private lateinit var INTENT: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding!!.root
        setContentView(view)
        INTENT = Intent(this,MediaIntentService::class.java)



        activityMainBinding!!.btnStart.setOnClickListener(this)
        activityMainBinding!!.btnStop.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v)
        {
            activityMainBinding!!.btnStart -> {
                startService(INTENT)
                    activityMainBinding!!.txtStatus.text = "Service is running"

            }
            activityMainBinding!!.btnStop->{

                stopService(INTENT)


            }
        }
    }
}