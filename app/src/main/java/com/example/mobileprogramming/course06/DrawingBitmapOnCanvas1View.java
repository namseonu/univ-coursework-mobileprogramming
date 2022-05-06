package com.example.mobileprogramming.course06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mobileprogramming.R;

public class DrawingBitmapOnCanvas1View extends View {

    public DrawingBitmapOnCanvas1View(Context c) {
        super(c);
    }

    public DrawingBitmapOnCanvas1View(Context c, AttributeSet a) {
        super(c, a);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap sm = BitmapFactory.decodeResource(getResources(), R.drawable.image);

        Paint Pnt = new Paint();
        canvas.drawColor(Color.WHITE);

        Bitmap bitm2 = Bitmap.createBitmap(sm, 0, 0, sm.getWidth() - 100, sm.getHeight() - 100);
        canvas.drawBitmap(bitm2, 0, 0, Pnt);
    }
}
