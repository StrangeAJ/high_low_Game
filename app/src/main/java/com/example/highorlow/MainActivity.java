package com.example.highorlow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.TimeUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static Random rand = new Random();
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
static int k = rand.nextInt(20)+1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView check_btn = findViewById(R.id.button_check);
        TextView reset_btn = findViewById(R.id.button_reset);
        EditText input_guess = findViewById(R.id.editTextNumber);
        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guess = Integer.parseInt(input_guess.getText().toString());
                if(guess>k){
                    Toast.makeText(getApplicationContext(), "U guessed bigger", Toast.LENGTH_SHORT).show();
                }
                if(guess<k){
                    Toast.makeText(getApplicationContext(), "U guessed Small", Toast.LENGTH_SHORT).show();
                }
                if(guess==k){
                    Toast.makeText(getApplicationContext(), "There You are!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getApplicationContext(),Congo.class);
                    in.putExtra("Extra",k);
                    startActivity(in);
                    k = rand.nextInt(20)+1;
                    for(int i =0;i<1000;i++){}
                    Toast.makeText(getApplicationContext(), "We Reseted The Number For You", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k = rand.nextInt(20)+1;
                Toast.makeText(getApplicationContext(), "Reseted the number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}