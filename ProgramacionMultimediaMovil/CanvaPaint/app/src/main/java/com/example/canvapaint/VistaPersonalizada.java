package com.example.canvapaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class VistaPersonalizada extends View {

    float posx = 0;
    float posy = 0;

    public VistaPersonalizada(Context context) {
        super(context);
    }

    public VistaPersonalizada(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VistaPersonalizada(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VistaPersonalizada(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas lienzo){
        super.onDraw(lienzo);


        Paint pincel = new Paint();

        pincel.setARGB(255, 70, 70, 70);
        pincel.setStyle(Paint.Style.FILL_AND_STROKE);
        pincel.setStrokeWidth(10);

        Paint brocha = new Paint();
        pincel.setARGB(255, 0, 0, 70);
        pincel.setStyle(Paint.Style.FILL_AND_STROKE);
        pincel.setStrokeWidth(10);

        lienzo.drawCircle(posx, posy, 100, pincel);
        lienzo.drawRect(0, 20, 100, 100, brocha);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN: posx=event.getX(); posy=event.getY()
            ;invalidate();
            ;break;

        }
        return super.onTouchEvent(event);
    }
}
