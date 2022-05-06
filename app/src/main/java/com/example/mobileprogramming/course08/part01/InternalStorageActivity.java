package com.example.mobileprogramming.course08.part01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageActivity extends AppCompatActivity {
    private final static String NOTES = "notes.txt";
    private EditText txtUIData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        txtUIData = (EditText) findViewById(R.id.txtUIData);
        Button btn = (Button) findViewById(R.id.close);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(NOTES, 0));
            out.write(txtUIData.getText().toString());
            out.close();
        } catch(Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        try {
            InputStream in = openFileInput(NOTES);

            if(in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";
                StringBuffer buf = new StringBuffer();

                while((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                }

                in.close();
                txtUIData.setText(buf.toString());
            } // if
        } catch (java.io.FileNotFoundException e) {
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
