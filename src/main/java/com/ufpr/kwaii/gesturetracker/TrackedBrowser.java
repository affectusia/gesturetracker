package com.ufpr.kwaii.gesturetracker;

import android.os.Build;
import android.util.Log;
import android.webkit.WebView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.RequiresApi;

import com.ufpr.kwaii.gesturetracker.model.Gesture;
import com.ufpr.kwaii.gesturetracker.model.Point;

import java.util.ArrayList;

public class TrackedBrowser extends WebView {

    private ArrayList<Gesture> gestures = new ArrayList<Gesture>();
    private boolean moving = false;
    private Gesture currentGesture= null;

    public TrackedBrowser(Context context){
        super(context);
    }

    public TrackedBrowser(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public TrackedBrowser(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();


        switch(action & MotionEvent.ACTION_MASK)
        {
            case MotionEvent.ACTION_POINTER_DOWN:
                int count = event.getPointerCount();
                Log.d("Fingers count: ", ""+ count);

                break;
        }

        if(action == MotionEvent.ACTION_DOWN){
            Gesture gesture = new Gesture();

            gesture.type = MotionEvent.actionToString(action);
            gesture.initialPoint = new Point(event.getX(), event.getY());
            gesture.finalPoint = new Point(event.getX(), event.getY());
            gesture.pressure = event.getPressure();

            gestures.add(gesture);
        }

        if(action == MotionEvent.ACTION_MOVE){
            if(!moving) {
                Gesture currentGesture = new Gesture();

                currentGesture.type = MotionEvent.actionToString(action);
                currentGesture.initialPoint = new Point(event.getX(), event.getY());
                currentGesture.pressure = event.getPressure();

                moving = true;
            }
        }

        if(action == MotionEvent.ACTION_UP){
            if(moving & currentGesture!=null){
                currentGesture.finalPoint = new Point(event.getX(), event.getY());
                moving = false;
                gestures.add(currentGesture);
            }

            currentGesture = null;
        }

        for (Gesture gesture: gestures)
            Log.d("gesture", ""+ gesture);

        return super.onTouchEvent(event);
    }

    public void onLongPress(MotionEvent e) {
        Log.e("", "Longpress detected");
    }

}
