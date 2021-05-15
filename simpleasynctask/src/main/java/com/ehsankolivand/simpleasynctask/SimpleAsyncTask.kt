package com.ehsankolivand.simpleasynctask

import android.os.AsyncTask
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import java.lang.ref.WeakReference
import java.util.*
const val TEXT_STATE:String = "currentText"
class SimpleAsyncTask(tv: TextView) : AsyncTask<Void, Void, String>() {

    private var mTextView: WeakReference<TextView> = WeakReference(tv)

    override fun onPreExecute() {
        super.onPreExecute()
    }
    override fun doInBackground(vararg params: Void?): String {

        var random = Random()
        var n = random.nextInt(100)
        var s:Long = (n*200).toLong()
        try {
            Thread.sleep(s)
        }catch (e: InterruptedException)
        {
            e.printStackTrace()
        }
        return "Awake at last after sleeping for $s milliseconds!"
    }

    override fun onPostExecute(result: String?) {
        mTextView.get()!!.text = result

    }

}