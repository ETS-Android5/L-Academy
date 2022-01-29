package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Represents an individual item in the habits listview
 */
public class CourseAdapter  extends ArrayAdapter<Course> {
    /**
     * The list of habits
     */
    private final ArrayList<Course> courses;
    private Context context;

    final int INVALID_ID = -1;
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    // Constructor
    public CourseAdapter(Context context, ArrayList<Course> courses){
        super(context, R.layout.course_list_adapter, courses);
        this.courses = courses;
        this.context = context;
    }

    /**
     * This function returns the view of the habit object containing the name, title, and date
     * @param position The position of the habit in the list
     * @param convertView The converted view of the habit object
     * @param parent The parent group
     * @return The view of the habit object in the list
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.course_list_adapter, parent, false);
        }

        Course course = courses.get(position);

        // Initializing TextView with IDs of TextViews in the layout
        TextView courseName  = view.findViewById(R.id.course_name);
        TextView difficulty = view.findViewById(R.id.difficulty);

        // Setting name and title of the habit in the TextViews
        courseName.setText(course.getCourseName());
        difficulty.setText(course.getDifficulty());

        return view;
    }


}
