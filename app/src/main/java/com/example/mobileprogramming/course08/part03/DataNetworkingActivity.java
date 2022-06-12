package com.example.mobileprogramming.course08.part03;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class DataNetworkingActivity extends AppCompatActivity {
    Button button01;
    EditText input01;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_networking);

        button01 = (Button) findViewById(R.id.button01);
        input01 = (EditText) findViewById(R.id.editText01);

        button01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String addr = input01.getText().toString().trim();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }

    class ConnectThread extends Thread {
        String hostname;

        public ConnectThread(String addr) {
            hostname = addr;
        }

        public void run() {
            try {
                int port = 7777;

                Socket sock = new Socket(hostname, port);

                InputStream in = sock.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                Log.d("MainActivity", "서버에서 받은 메시지 : " + dis.readUTF());
                dis.close();
                sock.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
