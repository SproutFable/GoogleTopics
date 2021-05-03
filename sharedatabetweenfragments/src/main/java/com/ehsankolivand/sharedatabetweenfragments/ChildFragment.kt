package com.ehsankolivand.sharedatabetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentChildBinding
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentOneBinding


class ChildFragment : Fragment() {


    private var _binding: FragmentChildBinding?=null
    private val binding get() = _binding!!
    private val shareDataViewModel:ShareDataViewModel by viewModels({requireParentFragment()})


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChildBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        shareDataViewModel.selectItem.observe(this, Observer {
            context?.let { it1 -> it.showMsg(it1,"From Child") }
        })

        binding.btnChangeStateFalse.setOnClickListener {
            shareDataViewModel.changeState(false)
        }
        binding.btnChangeStateTrue.setOnClickListener {
            shareDataViewModel.changeState(true)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = ChildFragment()
    }
}