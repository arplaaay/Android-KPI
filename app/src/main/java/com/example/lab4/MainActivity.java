package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button soundButton;
    Button videoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundButton = findViewById(R.id.act_change_sound);
        soundButton.setOnClickListener(v -> {
            Intent intent_sound = new Intent(MainActivity.this, Sound.class);
            startActivity(intent_sound);
        });

        videoButton = findViewById(R.id.act_change_video);
        videoButton.setOnClickListener(v -> {
            Intent intent_video = new Intent(MainActivity.this, Video.class);
            startActivity(intent_video);
        });
    }
}