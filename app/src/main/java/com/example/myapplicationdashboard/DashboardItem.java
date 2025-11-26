package com.example.myapplicationdashboard;
public class DashboardItem {
    private final String title;
    private final int icon;
    private final String color;

    public DashboardItem(String title, int icon, String color) {
        this.title = title;
        this.icon = icon;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public String getColor() {
        return color;
    }
}
