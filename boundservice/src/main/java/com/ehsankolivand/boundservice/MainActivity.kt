package com.ehsankolivand.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ehsankolivand.boundservice.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var activityMainBinding: ActivityMainBinding?=null

    private lateinit var  myBoundService:MyBoundService

    private var mService: Messenger? = null
    private var bound: Boolean = false
    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
            mService = Messenger(service)
            bound = true
        }

        override fun onServiceDisconnected(className: ComponentName) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            mService = null
            bound = false
        }
    }

    fun sayHello(v: View) {
        if (!bound) return
        // Create and send a message to the service, using a supported 'what' value
        val msg: Message = Message.obtain(null, MSG_SAY_HELLO, 0, 0)
        try {
            mService?.send(msg)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }

    }


    private var mBound: Boolean = false


    private val serviceConnection = object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyBoundService.LocalBinder
            myBoundService = binder.getService()
            mBound=  true


        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding!!.root.apply {
            setContentView(this)


        }

        activityMainBinding!!.button.setOnClickListener(this)
        activityMainBinding!!.btnMessage.setOnClickListener {
            sayHello(it)
        }
    }

    override fun onStart() {
        super.onStart()

        Intent(this, MyBoundService::class.java).also { intent ->
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }
        Intent(this, MessengerService::class.java).also { intent ->
            bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
        }

    }



    override fun onStop() {
        super.onStop()
        if (mBound) {
            unbindService(serviceConnection)
            mBound = false
        }
        if (bound) {
            unbindService(mConnection)
            bound = false
        }
    }


    override fun onClick(v: View?) {
        if (mBound)
        activityMainBinding!!.button.text = myBoundService.randomNumber.toString()
        else
            Toast.makeText(this,"not bind",Toast.LENGTH_LONG).show()
    }




}