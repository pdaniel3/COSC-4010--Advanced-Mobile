package edu.uwy.pdaniel3.program2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureDisplayActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_display);

        mImageView = (ImageView) findViewById(R.id.imageView);

        if (getIntent().hasExtra("byteArray")) {
            ImageView _imv = new ImageView(this);
            Bitmap _bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            _imv.setImageBitmap(_bitmap);


            mImageView.setImageBitmap(_bitmap);

        }
    }
}
