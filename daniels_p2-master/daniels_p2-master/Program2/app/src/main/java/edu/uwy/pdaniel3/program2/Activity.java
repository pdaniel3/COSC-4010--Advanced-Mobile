package edu.uwy.pdaniel3.program2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        Intent i = new Intent(Activity.this, MainActivity.class);
        startActivity(i);
    }
}
