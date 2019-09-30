package com.example.ontapgk_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DSTacGia_Activity extends AppCompatActivity {

    ListView lvtacgia;
    ArrayAdapter<TacGia> adapter;
    ArrayList<TacGia> arrTG = new ArrayList<TacGia>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dstac_gia_);

        Intent intent = getIntent();
        ArrayList<String> danhSachMa = intent.getStringArrayListExtra("ID_LIST");
        ArrayList<String> danhSachTen = intent.getStringArrayListExtra("NAME_LIST");

        if(danhSachMa != null && danhSachTen != null) {
            for(int i = 0; i < danhSachMa.size(); i++) {
                arrTG.add(new TacGia(danhSachMa.get(i), danhSachTen.get(i)));
            }
        }

        lvtacgia = findViewById(R.id.lvTacGia);
        adapter = new ArrayAdapter<TacGia>(this, android.R.layout.simple_list_item_1, arrTG);
        lvtacgia.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lvtacgia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
