package com.example.mobileprogramming.course06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.mobileprogramming.R;

public class DrawingBitmapOnCanvas2View extends View {

    public DrawingBitmapOnCanvas2View(Context c) {
        super(c);
    }

    public DrawingBitmapOnCanvas2View(Context c, AttributeSet a) {
        super(c, a);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap sm = BitmapFactory.decodeResource(getResources(), R.drawable.image);

        Paint Pnt = new Paint();
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(sm, new Rect(100, 0, 500, 500), new Rect(0, 0, 400, 500), Pnt);
    }
}
