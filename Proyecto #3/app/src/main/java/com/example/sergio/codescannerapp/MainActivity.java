package com.example.sergio.codescannerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MainActivity extends AppCompatActivity {
    public static TextView resultTextView;
    public static TextView resultTextView2;
    public static TextView tvResult;
    public static TextView tvIsConnected;

    Button scan_btn;
    public static int friendcounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView=(TextView)findViewById(R.id.result_text);
        resultTextView2=(TextView)findViewById(R.id.result_text2);
        resultTextView2.setMovementMethod(new ScrollingMovementMethod());

        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        scan_btn = (Button) findViewById(R.id.btn_scan);
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendcounter+=1;
                startActivity(new Intent(getApplicationContext(),ScanCodeActivity.class));

            }
        });

        checkNetworkConnection();
    }

    public boolean checkNetworkConnection() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            // show "Connected" & type of network "WIFI or MOBILE"
            tvIsConnected.setText("Connected "+networkInfo.getTypeName());
            // change background color to red
            tvIsConnected.setBackgroundColor(0xFF7CCC26);


        } else {
            // show "Not Connected"
            tvIsConnected.setText("Not Connected");
            // change background color to green
            tvIsConnected.setBackgroundColor(0xFFFF0000);
        }

        return isConnected;
    }




}
