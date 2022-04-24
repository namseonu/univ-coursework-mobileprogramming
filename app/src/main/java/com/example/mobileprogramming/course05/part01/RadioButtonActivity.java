package com.example.mobileprogramming.course05.part01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class RadioButtonActivity extends AppCompatActivity {
    CheckBox chkCream;
    CheckBox chkSugar;
    Button btnPay;
    RadioGroup radCoffeeType;
    RadioButton radDecaf;
    RadioButton radEspresso;
    RadioButton radColombian;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        btnPay = findViewById(R.id.btnPay);
        radCoffeeType = findViewById(R.id.radGroupCoffeeType);
        radDecaf = findViewById(R.id.radDecaf);
        radEspresso = findViewById(R.id.radExpresso);
        radColombian = findViewById(R.id.radColombian);

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

                int radioId = radCoffeeType.getCheckedRadioButtonId();

                if(radDecaf.getId() == radioId)
                    msg = "Decaf " + msg;
                if(radColombian.getId() == radioId)
                    msg = "Colombian " + msg;
                if(radEspresso.isChecked())
                    msg = "Espresso " + msg;

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
