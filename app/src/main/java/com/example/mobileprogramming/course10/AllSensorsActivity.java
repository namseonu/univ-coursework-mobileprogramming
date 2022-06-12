package com.example.mobileprogramming.course10;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

import java.util.List;

public class AllSensorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sensors);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> arSensor = sm.getSensorList(Sensor.TYPE_ALL);
        String result = " 갯수 : " + arSensor.size() + "\n\n";

        for (Sensor s : arSensor) {
            result += ("이름 = " + s.getName() + ",\n 형식 = " + s.getType() + ", \n 제조사 = " + s.getVendor() + ",\n 전원 = " + s.getPower() + ",\n 해상도 = " + s.getResolution() + ",\n 범위 = " +s.getMaximumRange() + "\n\n");
        }

        TextView txtResult = (TextView) findViewById(R.id.result);
        txtResult.setText(result);
    }
}
