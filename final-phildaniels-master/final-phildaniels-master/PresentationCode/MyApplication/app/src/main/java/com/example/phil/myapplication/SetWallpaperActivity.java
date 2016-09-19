package com.example.phil.myapplication;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class SetWallpaperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wallpaper);

        WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(getApplicationContext());
            //myWallpaperManager.setResource(R.drawable.trolol);

    }
}
