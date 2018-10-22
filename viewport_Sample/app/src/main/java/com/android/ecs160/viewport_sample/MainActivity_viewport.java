package com.android.ecs160.viewport_sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity_viewport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewport);

        //Custom View - ViewportView
        ViewportView map = (ViewportView) findViewById(R.id.map);
        Bitmap terrain = BitmapFactory.decodeResource(map.getResources(), R.drawable.map_pokemon);
        //map.setImageBitmap(terrain);  // No Scaling

        //Scaling - 2000px in height
        float factor = (float) terrain.getWidth() / (float) terrain.getHeight();
        Bitmap scaledTerrain = Bitmap.createScaledBitmap(terrain, (int) (2000 * factor), 2000, true);
        map.setImageBitmap(scaledTerrain);

    }
}
