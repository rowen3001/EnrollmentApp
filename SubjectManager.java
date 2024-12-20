package com.example.localservice;

import java.util.ArrayList;

public class SubjectManager {
    // Mock data, replace with actual data source or API calls
    public ArrayList<subject_item> getEnrolledSubjects() {
        ArrayList<subject_item> subjects = new ArrayList<>();
        subjects.add(new subject_item("Mathematics", 3));
        subjects.add(new subject_item("Physics", 4));
        return subjects;
    }
}
