package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ListView coursesView;
    ProgressBar progressBar;
    TextView currentCourseText;
    CourseAdapter courseAdapter;
    ArrayList<Course> courseArrayList;
    FloatingActionButton confirmCourseButton;

    int courseSelectedPosition = -1;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference coursesRef = db.collection("Courses");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        coursesView = findViewById(R.id.listView);
        progressBar = findViewById(R.id.progressBar);
        currentCourseText = findViewById(R.id.textView4);


        courseArrayList = new ArrayList<>();
        courseAdapter = new CourseAdapter(HomeActivity.this, courseArrayList);

        coursesRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for (QueryDocumentSnapshot doc: value) {
                    String courseName = (String)doc.getData().get("courseName");
                    String courseContent = (String)doc.getData().get("courseContent");
                    String difficulty = (String)doc.getData().get("difficulty");
                    Course course = new Course(courseName, courseContent, difficulty);
                    courseArrayList.add(course);
                }
                courseAdapter.notifyDataSetChanged();
            }
        });
        coursesView.setAdapter(courseAdapter);

        coursesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                courseSelectedPosition = position;
                currentCourseText.setText(courseArrayList.get(position).getCourseName());
            }
        });

        confirmCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (courseSelectedPosition != -1) {
                    Intent viewCourseIntent = new Intent();
                    String courseContent = courseArrayList.get(courseSelectedPosition).getCourseContent();
                    viewCourseIntent.putExtra("courseContent", courseContent);
                }
            }
        });
    }

}