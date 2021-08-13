package com.example.highorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Congo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congo);
        Intent in = getIntent();
        int k = in.getExtras().getInt("Extra");
        TextView nmbr = findViewById(R.id.textView);
       nmbr.setText(String.valueOf(k));
    }
}