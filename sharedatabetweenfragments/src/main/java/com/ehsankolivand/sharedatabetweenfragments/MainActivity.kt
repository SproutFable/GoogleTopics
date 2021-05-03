package com.ehsankolivand.sharedatabetweenfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.ehsankolivand.sharedatabetweenfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
 /*   lateinit var fragmentOne:FragmentOne
    lateinit var fragmentTwo: FragmentTwo
*/
    lateinit var parentFragment: ParentFragment

    private val viewModel:ShareDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

    /*
       // Share data between fragments

        fragmentOne = FragmentOne.newInstance()
        fragmentTwo = FragmentTwo.newInstance()
        supportFragmentManager.commit {
            add(R.id.fragment_container,fragmentOne)
            add(R.id.fragment_container,fragmentTwo)
            addToBackStack("")
        }
*/

        //Share data between a parent and child fragment

        parentFragment = ParentFragment.newInstance()
        supportFragmentManager.commit {
            add(R.id.fragment_container,parentFragment)
            //setPrimaryNavigationFragment(parentFragment)
            addToBackStack("")

        }



    }
}