package com.example.myapplicationdashboard;
public class AttendanceRecord {
    String subject;
    int presentDays;
    int absentDays;

    public AttendanceRecord(String subject, int presentDays, int absentDays) {
        this.subject = subject;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
    }

    public String getSubject() {
        return subject;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public int getTotalDays() {
        return presentDays + absentDays;
    }

    public int getPercentage() {
        return (int)((presentDays * 100.0f) / getTotalDays());
    }
}
