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
import com.ehsankolivand.sharedatabetweenfragments.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    private var _binding: FragmentTwoBinding?=null
    private val binding get() = _binding!!
    private val viewModel:ShareDataViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoBinding.inflate(inflater,container,false)
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
    fun showToast(boolean: Boolean)
    {
        Toast.makeText(context,"$boolean FromTwo", Toast.LENGTH_LONG).show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentTwo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            FragmentTwo().apply {
                arguments = Bundle()
            }
    }
}