package com.ehsankolivand.recentsscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.recentsscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var activityMainBinding: ActivityMainBinding ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding!!.root
        setContentView(view)

        val intent = Intent(this,MainActivity2::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);

        activityMainBinding!!.btn1.setOnClickListener {
            startActivity(intent)
        }
    }
}
