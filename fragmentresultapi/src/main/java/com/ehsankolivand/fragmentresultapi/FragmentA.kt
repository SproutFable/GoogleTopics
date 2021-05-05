package com.ehsankolivand.fragmentresultapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.ehsankolivand.fragmentresultapi.databinding.FragmentABinding


class FragmentA : Fragment() {
    private var _binding: FragmentABinding?=null
    private val binding get() = _binding!!
    lateinit var fragmentB:FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setFragmentResultListener("requestKey") {
            requestKey, bundle ->
            val result = bundle.getString("bundleKey")

            Toast.makeText(context,result,Toast.LENGTH_LONG).show()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentABinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnChangeStateTrue.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentB)
        }

        binding.btnChangeStateTrue.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentB.newInstance()).addToBackStack("fragA").commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FragmentA()
    }
}