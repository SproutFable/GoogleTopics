package com.ehsankolivand.sharedatabetweenfragments

import android.content.Context
import android.widget.Toast

fun Boolean.showMsg(context: Context,strFrom: String){
    Toast.makeText(context,"$this from $strFrom",Toast.LENGTH_SHORT).show()
}