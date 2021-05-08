package com.ehsankolivand.recentsscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.recentsscreen.databinding.ActivityMain2Binding
import com.ehsankolivand.recentsscreen.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    var activityMainBinding: ActivityMain2Binding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMain2Binding.inflate(layoutInflater)
        val view = activityMainBinding!!.root
        setContentView(view)

        val intent = Intent(this,MainActivity3::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);

        activityMainBinding!!.btn2.setOnClickListener {
            startActivity(intent)
        }
    }
}