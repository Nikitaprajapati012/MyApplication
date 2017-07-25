package com.example.priyanka.myapplication.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

/*** Created by nikita on 21/7/17.
 */

public class MyScheduleReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conMngr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = conMngr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo mobile = conMngr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        Log.d("connection", "WIFI@@" + wifi);
        Log.d("connection", "MOBILE@@" + mobile);

        // TODO: 21/7/17 other way to check network state change 
        Log.d("action", "action:@ " + intent.getAction());
        Log.d("component", "component:@ " + intent.getComponent());
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                Log.d("key", "@key [" + key + "]: " +
                        extras.get(key));
            }
        } else {
            Log.v("no extras", "@no extras");
        }
    }
}
