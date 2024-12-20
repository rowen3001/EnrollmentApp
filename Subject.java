package com.example.localservice;

class SubjectItem {
    private String name;
    private int credits;

    public void Subject(String name, int credits) {
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
