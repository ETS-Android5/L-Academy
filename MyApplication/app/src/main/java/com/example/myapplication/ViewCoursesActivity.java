package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

public class ViewCoursesActivity extends AppCompatActivity {
    ImageButton backButton;
    ImageButton onlineChatButton;
    VideoView videoCourseView;
    ImageButton takeTestButton;
    TextView viewParagraph;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        String courseContent = receivedIntent.getExtras().getString("courseContent");
        setContentView(R.layout.activity_view_courses);
        backButton = findViewById(R.id.imageButton3);
        onlineChatButton = findViewById(R.id.imageButton5);
        videoCourseView = findViewById(R.id.videoView);
        takeTestButton = findViewById(R.id.imageButton4);
        viewParagraph = findViewById(R.id.textView9);
        videoCourseView = findViewById(R.id.videoView);
        viewParagraph.setText(courseContent);
        int lineCount = (int)courseContent.chars().filter(ch -> ch == '\n').count();
        viewParagraph.setMaxLines(100);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        onlineChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCoursesActivity.this, CallingActivity.class);
                startActivity(intent);
            }
        });
        takeTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCoursesActivity.this, MCQActivity.class);
                startActivity(intent);
            }
        });
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.part;
        Uri uri = Uri.parse(videoPath);
        videoCourseView.setVideoURI(uri);
        videoCourseView.start();

    }
}