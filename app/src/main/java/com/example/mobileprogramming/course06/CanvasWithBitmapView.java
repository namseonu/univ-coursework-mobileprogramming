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

    // 두 개의 이미지를 가져 오기 위해
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

    // 눌렀다가 손이 떼어졌을 때
    public boolean onTouchEvent(MotionEvent event) {
        // if it's an up ("release") action
        // 현재 nAngle에 회전하고 싶은 만큼 회전값을 더해주면 됨.
        if(event.getAction() == MotionEvent.ACTION_UP) {
            nAngle = nAngle + 5;    // 360도를 넘어도 우리가 따로 처리해줘야 할 건 없음.

            // invalidate()가 없으면 onTouchEvent는 눌렸을 때 반응하는 이벤트일 뿐.
            // 현재 그리고 있는 영역이 무효하므로 운영체제에게 알려줌으로써 onDraw가 다시 불리도록 해야 한다.
            // 즉, onDraw()를 직접 부를 수는 없고, invalidate()을 통해서 알려준다.
            invalidate();
        }

        // indicates that the event was handled
        return true;
    } // end of onTouchEvent

    // 화면이 가려졌다가 다시 올라왔을 때 (onResume) onDraw가 불린다.
    // 시스템이 상황에 다라 다시 그려줘야 할 때 onDraw가 알아서 그려준다.
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mAndroidGreen, 0, 0, mPaint);
        canvas.save();

        canvas.rotate(nAngle);
        canvas.drawBitmap(mAndroidRed, 0, 0, mPaint);
    }
}
