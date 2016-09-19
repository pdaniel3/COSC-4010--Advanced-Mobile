package com.example.phil.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VibrateActivity extends Activity {

    private Vibrator annoyance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        annoyance = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        while(true) {
            annoyance.vibrate(100);
        }

    }

}
