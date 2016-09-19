package edu.uwy.pdaniel3.program2;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.LatLng;

public class Pairs {

    private LatLng latlng;
    private Bitmap bitmap;

    public Pairs(LatLng latlng, Bitmap bitmap)
    {
        this.latlng = latlng;
        this.bitmap = bitmap;
    }

    public LatLng getLatLng()
    {
        return latlng;
    }

    public Bitmap getBitMap()
    {
        return bitmap;
    }
}
