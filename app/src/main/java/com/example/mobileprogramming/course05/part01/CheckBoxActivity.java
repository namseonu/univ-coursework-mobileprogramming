package com.example.mobileprogramming.course05.part01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox chkCream;
    CheckBox chkSugar;
    Button btnPay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        btnPay = findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String msg = "Coffee ";

                if(chkCream.isChecked()) {
                    msg += " & cream ";
                }

                if(chkSugar.isChecked()) {
                    msg += " & Sugar";
                }

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
