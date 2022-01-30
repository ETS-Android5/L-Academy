package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MCQActivity extends AppCompatActivity {
    ImageButton backButton;
    ImageButton onlineChatButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcq_test);
        backButton = findViewById(R.id.imageButton3);
        onlineChatButton = findViewById(R.id.imageButton7);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        onlineChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MCQActivity.this, CallingActivity.class);
                startActivity(intent);
            }
        });
    }
}