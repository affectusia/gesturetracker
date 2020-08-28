package com.ufpr.kwaii.gesturetracker.model;

public class Point {

    private Float x;
    private Float y;

    public Point(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "[" + x + "," + y + "]";
    }

}
