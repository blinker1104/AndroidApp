package com.android.ecs160.viewport_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());


        //Direct ImageView Example

        //ImageView map = (ImageView) findViewById(R.id.map);

        //ImageViewer map = new ImageViewer(findViewById(R.id.map).getContext(), null);
        ImageViewer map = (ImageViewer) findViewById(R.id.map);
        Bitmap terrain = BitmapFactory.decodeResource(map.getResources(), R.drawable.map_pokemon);
        //map.setImageBitmap(terrain);

        //Scaling
        float factor = (float) terrain.getWidth() / (float) terrain.getHeight();
        Bitmap scaledTerrain = Bitmap.createScaledBitmap(terrain, (int) (2000 * factor), 2000, true);
        map.setImageBitmap(scaledTerrain);


        //ImageViewer
        //ImageViewer viewport = new ImageViewer(findViewById(R.id.map).getContext(), null);
        //Bitmap terrain = BitmapFactory.decodeResource(getResources(), R.drawable.map_pokemon);
        //viewport.setImageBitmap(terrain);
        //viewport.onDraw(new Canvas(ter));

        //((ImageView)findViewById(R.id.map)).setImageBitmap(terrain);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
