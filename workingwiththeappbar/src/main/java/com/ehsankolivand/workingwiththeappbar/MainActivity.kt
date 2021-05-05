package com.ehsankolivand.workingwiththeappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.ehsankolivand.workingwiththeappbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  var _bnding:ActivityMainBinding?=null
    private val binding get() = _bnding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bnding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)




        supportFragmentManager.commit {
            add(R.id.fragmentContainerView,TestAppBarA.newInstance())
            addToBackStack("testA")
        }
    }
}