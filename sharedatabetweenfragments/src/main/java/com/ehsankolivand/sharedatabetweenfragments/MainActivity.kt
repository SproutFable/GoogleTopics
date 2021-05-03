package com.ehsankolivand.sharedatabetweenfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.ehsankolivand.sharedatabetweenfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    lateinit var fragmentOne:FragmentOne
    lateinit var fragmentTwo: FragmentTwo


    private val viewModel:ShareDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        fragmentOne = FragmentOne.newInstance()
        fragmentTwo = FragmentTwo.newInstance()
        supportFragmentManager.commit {
            add(R.id.fragment_container,fragmentOne)
            add(R.id.fragment_container,fragmentTwo)
            addToBackStack("")
        }


    }
}