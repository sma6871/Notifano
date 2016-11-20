package com.aka.adnotificationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aka.adnot.AdNotification;
import com.aka.adnot.utils.PackageData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PackageData.getInstance().context=this;
    }
    public void OnStartClick(View view)
    {
        PackageData.getInstance().SetIsStaticTime(false);
        AdNotification adNotification=new AdNotification(this,"b16d9e34-b0f6-408d-82ff-51c96d8d767d".toUpperCase());
        adNotification.Start();
        Toast.makeText(this,"AdNotification Started",Toast.LENGTH_LONG).show();
    }

    public void OnStartStaticClick(View view)
    {
        PackageData.getInstance().SetIsStaticTime(true);
        AdNotification adNotification=new AdNotification(this,"b16d9e34-b0f6-408d-82ff-51c96d8d767d".toUpperCase());
        adNotification.Start();
        Toast.makeText(this,"AdNotification Started",Toast.LENGTH_LONG).show();
    }

    public void OnStopClick(View view)
    {
        AdNotification adNotification=new AdNotification(this,"b16d9e34-b0f6-408d-82ff-51c96d8d767d".toUpperCase());
        adNotification.Stop();
        Toast.makeText(this,"AdNotification Stopped",Toast.LENGTH_LONG).show();
    }
}
