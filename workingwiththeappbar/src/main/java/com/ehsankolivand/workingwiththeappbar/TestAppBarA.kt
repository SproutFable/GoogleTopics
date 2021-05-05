package com.ehsankolivand.workingwiththeappbar

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ehsankolivand.workingwiththeappbar.databinding.FragmentTestAppBarABinding


class TestAppBarA : Fragment() {

    var isEditing = true
    private var _binding:FragmentTestAppBarABinding?=null
    private val biniding:FragmentTestAppBarABinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestAppBarABinding.inflate(layoutInflater,container,false)
        return biniding.root

    }

    fun clearToolbarMenu() {
        biniding.myToolbar.menu.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        biniding.myToolbar.inflateMenu(R.menu.simple_menu)
        biniding.myToolbar.setNavigationIcon(R.mipmap.ic_launcher_round)


        biniding.myToolbar.setOnMenuItemClickListener {
            when(it.itemId)
            {
                R.id.menu_first->{
                    Toast.makeText(context,"menu_first",Toast.LENGTH_LONG).show()
                    val saveItem = biniding.myToolbar.menu.findItem(R.id.menu_first)
                    saveItem.isVisible = false

                    true
                }
                R.id.menu_second->{
                    Toast.makeText(context,"menu_second",Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    Toast.makeText(context,"noting",Toast.LENGTH_LONG).show()

                    true
                }
            }
        }
      //  clearToolbarMenu()
    }
/*

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
*/
    companion object {

        @JvmStatic
        fun newInstance() =
            TestAppBarA()

    }
}