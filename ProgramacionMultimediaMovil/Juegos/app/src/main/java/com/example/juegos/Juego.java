package com.example.juegos;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Juego extends View {
    public Juego(Context context) {
        super(context);
    }

    public Juego(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Juego(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Juego(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onDrow(Canvas canvas){
        super.onDraw(canvas);

    }
}
