package com.ehsankolivand.workingwiththeappbar

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment


class TestAppBarA : Fragment() {

    var isEditing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_app_bar_a, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.simple_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_first ->{
                return true
            }
            R.id.menu_second ->{

                return false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
  fun updateOptionsMenu() {
      isEditing = !isEditing
      requireActivity().invalidateOptionsMenu()
  }

    override fun onPrepareOptionsMenu(menu: Menu){
        updateOptionsMenu()
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            TestAppBarA()

    }
}