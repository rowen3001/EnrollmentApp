package com.example.localservice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EnrollmentSummaryActivity extends AppCompatActivity {

    private ListView enrolledSubjectsListView;
    private TextView totalCreditsTextView;
    private SubjectManager subjectManager;
    private Button enrollButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment_summary);

        // Initialize UI components
        enrolledSubjectsListView = findViewById(R.id.enrolledSubjectsListView);
        totalCreditsTextView = findViewById(R.id.totalCreditsTextView);
        enrollButton = findViewById(R.id.enrollButton);

        // Initialize SubjectManager
        subjectManager = new SubjectManager();

        // Get enrolled subjects and display them
        ArrayList<subject_item> enrolledSubjects = subjectManager.getEnrolledSubjects();
        if (enrolledSubjects.isEmpty()) {
            Toast.makeText(this, "No subjects enrolled!", Toast.LENGTH_SHORT).show();
        }

        // Set adapter for the ListView
        SubjectAdapter adapter = new SubjectAdapter(this, enrolledSubjects);
        enrolledSubjectsListView.setAdapter(adapter);

        // Calculate total credits
        int totalCredits = 0;
        for (subject_item subject : enrolledSubjects) {
            totalCredits += subject.getCredits();
        }

        // Display total credits
        totalCreditsTextView.setText("Total Credits: " + totalCredits);

        // Set up the enroll button action
        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to EnrollmentSuccessActivity after enrollment
                Intent intent = new Intent(EnrollmentSummaryActivity.this, EnrollmentSuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}
