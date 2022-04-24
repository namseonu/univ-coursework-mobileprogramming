package com.example.mobileprogramming.course05.part01;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class EditTextActivity extends AppCompatActivity {
    TextView labelUserName;
    EditText txtUserName;
    Button btnBegin;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        context = getApplicationContext();

        labelUserName = findViewById(R.id.textView1);
        txtUserName = findViewById(R.id.txtUserName);
        btnBegin = findViewById(R.id.button1);

        btnBegin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userName = txtUserName.getText().toString();

                if(userName.compareTo("Seonwoo Nam") == 0) {
                    labelUserName.setText("OK, Please wait..");
                    Toast.makeText(context, "Hi!, " + userName, duration).show();
                }
                else {
                    Toast.makeText(context, userName + " is not a valid User", duration).show();
                }
            }
        });
    }
}
