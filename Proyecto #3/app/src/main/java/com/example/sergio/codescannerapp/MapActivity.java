package com.example.sergio.codescannerapp;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MapActivity extends AppCompatActivity {
    private int screenWidth;
    private int screenHeight;

    private ImageView carrito;

    private float carritoX;
    private float carritoY;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        carrito = (ImageView) findViewById(R.id.carrito);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        carrito.setX(-80.00f);
        carrito.setY(-80.00f);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        },0,20);

    }
    public void changePos(){
        carritoY -= 10;
        if(carrito.getY() + carrito.getHeight()<0){
            carritoX = (float) Math.floor(Math.random()*(screenWidth-carrito.getWidth()));
            carritoY = screenHeight+100.0f;
        }
        carrito.setX(carritoX);
        carrito.setY(carritoY);
    }

}
