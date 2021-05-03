package com.ehsankolivand.sharedatabetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentOneBinding


class FragmentOne : Fragment() {

    private var _binding:FragmentOneBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FragmentOne().apply {
                arguments = Bundle()
            }
    }
}