package com.ehsankolivand.displayingdialogswithdialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyDialogFragment()
            .show(supportFragmentManager,MyDialogFragment.TAG)


    }
}