package com.example.localservice;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentActivity extends AppCompatActivity {

    private ListView subjectListView;
    private TextView totalCreditsText;
    private List<subject_item> subjectList;
    private int totalCredits = 0;
    private final int MAX_CREDITS = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        subjectListView = findViewById(R.id.subjectListView);
        totalCreditsText = findViewById(R.id.totalCreditsText);

        // Initialize the list of subjects
        initializeSubjects();

        // Set up the adapter for the ListView
        SubjectAdapter adapter = new SubjectAdapter(this, subjectList);
        subjectListView.setAdapter(adapter);

        subjectListView.setOnItemClickListener((parent, view, position, id) -> {
            subject_item selectedSubject = subjectList.get(position);

            if (totalCredits + selectedSubject.getCredits() <= MAX_CREDITS) {
                totalCredits += selectedSubject.getCredits();
                Toast.makeText(this, "Added: " + selectedSubject.getName(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Cannot exceed " + MAX_CREDITS + " credits!", Toast.LENGTH_SHORT).show();
            }

            totalCreditsText.setText("Total Credits: " + totalCredits);
        });
    }

    private void initializeSubjects() {
        subjectList = new ArrayList<>();

        subjectList.add(new subject_item("Mathematics I", 3));
        subjectList.add(new subject_item("Physics I", 3));
        subjectList.add(new subject_item("Chemistry", 3));
        subjectList.add(new subject_item("Introduction to Programming", 3));
        subjectList.add(new subject_item("English Communication", 2));
        subjectList.add(new subject_item("Engineering Mechanics", 3));
        subjectList.add(new subject_item("Data Structures", 3));
        subjectList.add(new subject_item("Database Systems", 3));
        subjectList.add(new subject_item("Operating Systems", 3));
        subjectList.add(new subject_item("Computer Networks", 3));
        subjectList.add(new subject_item("Software Engineering", 3));
        subjectList.add(new subject_item("Discrete Mathematics", 3));
        subjectList.add(new subject_item("Artificial Intelligence", 3));
        subjectList.add(new subject_item("Machine Learning", 3));
        subjectList.add(new subject_item("Web Development", 3));
        subjectList.add(new subject_item("Mobile App Development", 3));
        subjectList.add(new subject_item("Project Management", 2));
        subjectList.add(new subject_item("Digital Logic Design", 3));
        subjectList.add(new subject_item("Embedded Systems", 3));
        subjectList.add(new subject_item("Ethics in Technology", 2));
        subjectList.add(new subject_item("Cloud Computing", 3));
        subjectList.add(new subject_item("Internet of Things", 3));
        subjectList.add(new subject_item("Cybersecurity", 3));
        subjectList.add(new subject_item("Big Data Analytics", 3));
    }
}
