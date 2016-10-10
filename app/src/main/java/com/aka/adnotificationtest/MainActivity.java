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
        AdNotification adNotification=new AdNotification(this,"1c8265b6-8c6d-4955-b940-3b1132fc2ffc");
        adNotification.Start();
        Toast.makeText(this,"AdNotification Started",Toast.LENGTH_LONG).show();
    }

    public void OnStartStaticClick(View view)
    {
        PackageData.getInstance().SetIsStaticTime(true);
        AdNotification adNotification=new AdNotification(this,"1c8265b6-8c6d-4955-b940-3b1132fc2ffc");
        adNotification.Start();
        Toast.makeText(this,"AdNotification Started",Toast.LENGTH_LONG).show();
    }

    public void OnStopClick(View view)
    {
        AdNotification adNotification=new AdNotification(this,"1c8265b6-8c6d-4955-b940-3b1132fc2ffc");
        adNotification.Stop();
        Toast.makeText(this,"AdNotification Stopped",Toast.LENGTH_LONG).show();
    }
}
