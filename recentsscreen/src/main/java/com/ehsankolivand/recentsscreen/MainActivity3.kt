package com.ehsankolivand.recentsscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ehsankolivand.recentsscreen.databinding.ActivityMain2Binding
import com.ehsankolivand.recentsscreen.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    var activityMainBinding: ActivityMain3Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMain3Binding.inflate(layoutInflater)
        val view = activityMainBinding!!.root
        setContentView(view)

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        activityMainBinding!!.btn3.setOnClickListener {
            startActivity(intent)
        }
    }
}