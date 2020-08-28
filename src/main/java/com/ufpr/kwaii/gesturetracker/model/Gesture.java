package com.ufpr.kwaii.gesturetracker.model;

public class Gesture {
    public Float pressure = null;
    public Point initialPoint = null;
    public Point finalPoint = null;
    public String type = null;


    @Override
    public String toString(){
        return "Type:" + type + " Initial Point:" + initialPoint + " Final Point:" + finalPoint + "Pressure:" + pressure;
    }
}