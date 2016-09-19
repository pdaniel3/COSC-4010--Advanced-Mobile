package edu.uwyo.pdaniel3.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ClientOrServer extends AppCompatActivity {


    private Button mServer, mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_or_server);

        mClient = (Button) findViewById(R.id.beclient);
        mClient.setText("Be the client");
        mClient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ClientOrServer.this, ClientGameActivity.class);
                startActivity(i);
            }
        });

        mServer = (Button) findViewById(R.id.beserver);
        mServer.setText("Be the server");
        mServer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ClientOrServer.this, ServerGameActivity.class);
                startActivity(i);
            }
        });
    }
}
