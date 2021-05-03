package com.ehsankolivand.sharedatabetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentChildBinding
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentParentBinding


class ParentFragment : Fragment() {
    private var _binding: FragmentParentBinding?=null
    private val binding get() = _binding!!
    private val viewModel:ShareDataViewModel by viewModels()
    lateinit var childFragment: ChildFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParentBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        childFragment = ChildFragment.newInstance()
        childFragmentManager.commit {
            add(R.id.fragment_container_parent,childFragment)
            addToBackStack("")
        }

        viewModel.selectItem.observe(this, Observer {
            context?.let { it1 -> it.showMsg(it1,"From Parent") }
        })

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ParentFragment()
    }
}