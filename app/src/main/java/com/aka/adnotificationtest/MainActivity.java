package com.aka.adnotificationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aka.adnot.AdNotification;
import com.aka.adnot.helpers.SharedPreferenceHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdNotification adNotification=new AdNotification(this,"ed89ee2d-6f5a-4884-a92d-27db3ae73240");
        SharedPreferenceHelper.setSharedPreferenceLong(this, "LastUpdate", System.currentTimeMillis()-2000000);
        adNotification.Start();

    }
    public void OnStartClick(View view)
    {
        AdNotification adNotification=new AdNotification(this,"ed89ee2d-6f5a-4884-a92d-27db3ae73240");
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
