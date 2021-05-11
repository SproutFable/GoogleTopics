package com.ehsankolivand.boundservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.boundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private var activityMainBinding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding!!.root.apply {
            setContentView(this)
        }



    }
}