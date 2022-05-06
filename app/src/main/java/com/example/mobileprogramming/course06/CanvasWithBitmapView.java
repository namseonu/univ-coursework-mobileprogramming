package com.example.mobileprogramming.course06;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.mobileprogramming.R;

public class CanvasWithBitmapView extends View {
    private Paint mPaint;
    private Bitmap mAndroidGreen;
    private Bitmap mAndroidRed;
    private int nAngle = 0;

    public void init() {
        mPaint = new Paint();

        Resources res = getResources();
        mAndroidGreen = BitmapFactory.decodeResource(res, R.drawable.android_green);
        mAndroidRed = BitmapFactory.decodeResource(res, R.drawable.android_red);
    }

    public CanvasWithBitmapView(Context c) {
        super(c);
        init();
    }

    public CanvasWithBitmapView(Context c, AttributeSet a) {
        super(c, a);
        init();
    }

    public boolean onTouchEvent(MotionEvent event) {
        // if it's an up ("release") action
        if(event.getAction() == MotionEvent.ACTION_UP) {
            nAngle = nAngle + 5;
            invalidate();
        }

        // indicates that the event was handled
        return true;
    } // end of onTouchEvent

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mAndroidGreen, 0, 0, mPaint);
        canvas.save();

        canvas.rotate(nAngle);
        canvas.drawBitmap(mAndroidRed, 0, 0, mPaint);
    }
}
