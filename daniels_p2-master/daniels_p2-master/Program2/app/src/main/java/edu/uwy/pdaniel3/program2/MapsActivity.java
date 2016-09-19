package edu.uwy.pdaniel3.program2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mMarker;
    private Button mButton;
    private double [] currentDoubleArray;
    private LatLng currentLatLng;
    private Bitmap currentBitmap;

    private ArrayList<Bitmap> bitmaps;
    private ArrayList<Marker> markers;
    private ArrayList<Pairs> pairs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mButton = (Button) findViewById(R.id.button);

        Intent intent = getIntent();
        currentDoubleArray = intent.getDoubleArrayExtra("doubleArray");


        if(currentDoubleArray != null) {
            currentLatLng = new LatLng(currentDoubleArray[0], currentDoubleArray[1]);
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //the picture is stored in the intent in the data key.
        //get the picture and show it in an the imagview.
        //Note the picture is not stored on the filesystem, so this is the only "copy" of the picture.
        currentBitmap = (Bitmap) data.getExtras().get("data");

        Intent i = new Intent(MapsActivity.this, MainActivity.class);
        startActivity(i);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(currentDoubleArray != null) {
            Pairs tempPair = new Pairs(currentLatLng, currentBitmap);
            pairs.add(tempPair);
        }

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String time = sdf.format(cal.getTime());
        if(currentLatLng != null)
            mMarker = mMap.addMarker(new MarkerOptions()
                    .position(currentLatLng)
                    .title("Pic at time " + time));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLatLng));

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                for (int i = 0; i < markers.size(); i++) {
                    if (mMarker.getPosition() == pairs.get(i).getLatLng()) {
                        Intent _intent = new Intent(MapsActivity.this, PictureDisplayActivity.class);

                        ByteArrayOutputStream _bs = new ByteArrayOutputStream();
                        pairs.get(i).getBitMap().compress(Bitmap.CompressFormat.PNG, 50, _bs);
                        _intent.putExtra("byteArray", _bs.toByteArray());
                        startActivity(_intent);
                        break;
                    }
                }
                return true;
            }
        });
    }
}
