package com.example.mobileprogramming.course06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaintStrokeCapAndJoinActivity extends AppCompatActivity {

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

            // 캡 모양 테스트
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(16);

            // BUTT
            canvas.drawLine(50, 30, 240, 30, pnt);

            // ROUND
            pnt.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 60, 240, 60, pnt);

            // SQUARE
            pnt.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawLine(50, 90, 240, 90, pnt);

            // 조인 모양 테스트
            pnt.setColor(Color.BLACK);
            pnt.setStrokeWidth(20);
            pnt.setStyle(Paint.Style.STROKE);

            // MITER (각진 모양)
            pnt.setStrokeJoin(Paint.Join.MITER);
            canvas.drawRect(50, 150, 90, 200, pnt);

            // BEVEL (둥글게 살짝 깎인 모양)
            pnt.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawRect(120, 150, 160, 200, pnt);

            // ROUND (둥근 모양)
            pnt.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawRect(190, 150, 230, 200, pnt);
        }
    }
}
