package com.gregspitz.chessapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A Chessboard view
 */

public class ChessboardView extends View implements View.OnClickListener {

    private Paint mLinePaint = new Paint();
    private int lightColor = Color.LTGRAY;
    private int darkColor = Color.BLUE;

    public ChessboardView(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public ChessboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public ChessboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
    }

    public ChessboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = canvas.getWidth();
        float squareWidth = width / 8;
        float height = canvas.getHeight();
        float squareHeight = height / 8;

        mLinePaint.setStrokeWidth(4.0f);
        mLinePaint.setColor(lightColor);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                canvas.drawRect(squareWidth * j, squareHeight * i,
                        squareWidth * j + squareWidth, squareHeight * i + squareHeight,
                        mLinePaint);
                flipColor();
            }
            flipColor();
        }
    }

    private void flipColor() {
        if (mLinePaint.getColor() == lightColor) {
            mLinePaint.setColor(darkColor);
        } else {
            mLinePaint.setColor(lightColor);
        }
    }

    public void showStartingPosition() {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Chessboard Clicked!", Toast.LENGTH_LONG).show();
    }
}
