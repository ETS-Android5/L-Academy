package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

public class ViewCoursesActivity extends AppCompatActivity {
    ImageButton backButton;
    Button onlineChatButton;
    VideoView videoCourseView;
    ImageButton takeTestButton;
    TextView viewParagraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);
        backButton = findViewById(R.id.imageButton1);
        onlineChatButton = findViewById(R.id.button2);
        videoCourseView = findViewById(R.id.videoView);
        takeTestButton = findViewById(R.id.imageButton2);
        viewParagraph = findViewById(R.id.paragraphText);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}