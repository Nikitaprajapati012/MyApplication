package com.example.priyanka.myapplication.Activity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.content.ComponentName


/*** Created by nikita on 20/7/17.
 */

class MyService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        //TODO do something useful
        return Service.START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        //TODO for communication return IBinder implementation
        return null
    }

    var i = Intent(this, MyService::class.java)
    override fun startService(service: Intent?): ComponentName {
        return super.startService(service)
    }
}