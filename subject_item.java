package com.example.localservice;

public class subject_item {
    private String name;
    private int credits;

    public subject_item(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
