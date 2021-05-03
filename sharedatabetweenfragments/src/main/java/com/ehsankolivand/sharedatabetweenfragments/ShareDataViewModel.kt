package com.ehsankolivand.sharedatabetweenfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareDataViewModel:ViewModel() {


    private val state = MutableLiveData<Boolean>()
    val selectItem: LiveData<Boolean> get() = state

    fun changeState(boolean: Boolean)
    {
        state.value = boolean
    }


}