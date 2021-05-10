package com.ehsankolivand.intentservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.intentservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var activityMainBinding: ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding!!.root
        setContentView(view)
    }
}