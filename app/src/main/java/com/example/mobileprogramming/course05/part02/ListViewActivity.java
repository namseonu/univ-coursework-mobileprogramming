package com.example.mobileprogramming.course05.part02;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // 1. ListView에서 보여줄 데이터 정의 (E.g., array 형태)
        String[] names = {"LEE", "CHOI", "KIM", "JEONG", "RHO"};

        // 2. XML에 있는 ListView에 정의한 array를 넣어줘야 하므로 ListView 객체를 받아온다.
        ListView listView = (ListView) findViewById(R.id.listView);

        // 3. Adapter를 하나 만든다. (E.g., ArrayAdapter)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        // 4. listView.setAdapter(adapter);
        listView.setAdapter(adapter);
    }
}
