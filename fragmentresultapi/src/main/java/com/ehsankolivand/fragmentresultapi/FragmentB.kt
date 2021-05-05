package com.ehsankolivand.fragmentresultapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.ehsankolivand.fragmentresultapi.databinding.FragmentBBinding
import kotlin.concurrent.fixedRateTimer


class FragmentB : Fragment() {

    private var _binding: FragmentBBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.btnEnter.setOnClickListener {
            val result = binding.etInput.text.toString()
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            parentFragmentManager.popBackStack()
        }


    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FragmentB()
    }
}