package com.ehsankolivand.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ehsankolivand.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var activityMainBinding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding!!.root
        setContentView(view)

        activityMainBinding!!.btnStart.setOnClickListener(this)
        activityMainBinding!!.btnStop.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v)
        {
            activityMainBinding!!.btnStart -> {

            }
            activityMainBinding!!.btnStop->{

            }
        }
    }
}