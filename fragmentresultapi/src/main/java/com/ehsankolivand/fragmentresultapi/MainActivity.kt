package com.ehsankolivand.fragmentresultapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.ehsankolivand.fragmentresultapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    lateinit var fragmentA:FragmentA
  //  lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        fragmentA = FragmentA.newInstance()
      //  fragmentB = FragmentB.newInstance()

        supportFragmentManager.commit {

            add(R.id.fragment_container,fragmentA,"first")
            addToBackStack("a")
            setPrimaryNavigationFragment(fragmentA)

        }
    }
}