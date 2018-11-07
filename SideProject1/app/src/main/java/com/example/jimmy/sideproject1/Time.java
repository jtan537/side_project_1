package com.example.jimmy.sideproject1;

public class Time {
    private int start;
    private int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Time{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
