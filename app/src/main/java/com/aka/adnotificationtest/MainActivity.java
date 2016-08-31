package com.aka.adnotificationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aka.adnot.AdNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnStartClick(View view)
    {
        AdNotification adNotification=new AdNotification(this,"1");
        adNotification.Start();
        Toast.makeText(this,"AdNotification Started",Toast.LENGTH_LONG).show();
    }

    public void OnStopClick(View view)
    {
        AdNotification adNotification=new AdNotification(this,"1");
        adNotification.Stop();
        Toast.makeText(this,"AdNotification Stopped",Toast.LENGTH_LONG).show();
    }
}
