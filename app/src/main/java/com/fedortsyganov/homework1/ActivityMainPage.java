package com.fedortsyganov.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMainPage extends Activity
{
    private String KEY = "HomeworkOne";
    private String VALUE = " Message from Homework 1 - it should be in Logcat ";
    private String ACTION = "xx.yy.zz";
    private Button button_sendNotification;

    //GitHub test commit. Commit and Push it.
    //If you reading this, please understand that i'm
    //learning Git and commits =)
//*******************************************************
    private void sendNotification()
    {
        Intent intent = new Intent();
        intent.putExtra(KEY, VALUE);
        intent.setAction(ACTION);
        sendBroadcast(intent);
    }
//******************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        button_sendNotification = (Button) findViewById(R.id.b_2send_broadcast);
        button_sendNotification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendNotification();
            }
        });

    }
}
