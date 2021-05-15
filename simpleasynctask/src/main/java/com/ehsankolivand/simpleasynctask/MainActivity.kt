package com.ehsankolivand.simpleasynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ehsankolivand.simpleasynctask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.root.apply {
            setContentView(this)

        }
        if (savedInstanceState!=null)
        {
            binding.textView1.text = savedInstanceState.getString(TEXT_STATE)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_STATE,binding.textView1.text.toString())
    }

    fun startTask(view: View) {
        SimpleAsyncTask(binding.textView1).execute()

    }
}