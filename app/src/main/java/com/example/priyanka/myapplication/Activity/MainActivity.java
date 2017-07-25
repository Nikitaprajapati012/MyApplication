package com.example.priyanka.myapplication.Activity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.priyanka.myapplication.BroadcastReceiver.MyScheduleReceiver;
import com.example.priyanka.myapplication.R;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        registerReceiver(
                new MyScheduleReceiver(),
                new IntentFilter(
                        ConnectivityManager.CONNECTIVITY_ACTION));
    }
}
