package com.fedortsyganov.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends Activity
{

    Button buttonGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        buttonGoBack = (Button) findViewById(R.id.b_back);
        buttonGoBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getBaseContext(), ActivityMainPage.class);
                startActivity(intent);
            }
        });
    }

}
