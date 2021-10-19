package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FDU", "onCreate: what is the log ??? have you some msg\n");

        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        count  = count+1;
        TextView textView  = (TextView) findViewById(R.id.text); ;
        Log.i("button","this is a button msg count: "+ count);
        textView.setText("button already log info : this is a button msg count: "+ count);
    }
}