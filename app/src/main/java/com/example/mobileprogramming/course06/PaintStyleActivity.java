package com.example.mobileprogramming.course06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaintStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);

            pnt.setStrokeWidth(8);      // 테두리 굵기 지정
            pnt.setColor(Color.RED);    // 빨간색으로 그리기

            // 채우기
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 50, 40, pnt);

            // 외곽선 그리기
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 50, 40, pnt);

            // 외곽선 및 채우기
            pnt.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250, 50, 40, pnt);

            // 파란색으로 채우고 빨간색으로 외곽선 그리기
            // 1. 파란색으로 채우기
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 150, 40, pnt);
            // 2. 빨간색으로 외곽선 그리기
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50, 150, 40, pnt);

            // 빨간색으로 외곽선 그리고 파란색으로 채우기
            // 1. 빨간색으로 외곽선 그리기
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 40, pnt);
            // 2. 파란색으로 채우기
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150, 150, 40, pnt);
        }
    }
}
