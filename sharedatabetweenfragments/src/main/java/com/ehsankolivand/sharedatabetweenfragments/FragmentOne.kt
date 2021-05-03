package com.ehsankolivand.sharedatabetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentOneBinding


class FragmentOne : Fragment() {

    private var _binding:FragmentOneBinding?=null
    private val binding get() = _binding!!


    private val viewModel:ShareDataViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.selectItem.observe(this, Observer {
    showToast(it)
        })

        binding.btnChangeStateFalse.setOnClickListener {
            viewModel.changeState(false)
        }
        binding.btnChangeStateTrue.setOnClickListener {
            viewModel.changeState(true)
        }
    }
    private fun showToast(boolean: Boolean)
    {
        Toast.makeText(context,"$boolean From One", Toast.LENGTH_LONG).show()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FragmentOne()
    }
}