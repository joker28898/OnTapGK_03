package com.example.ontapgk_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class QuanLyTacGia extends AppCompatActivity {

    Spinner spinner;
    EditText txtDATE, txtTIME;
    ArrayList<TacGia> arrTG = new ArrayList<>();
    ArrayAdapter<TacGia> adapter;
    final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tac_gia);

        spinner = findViewById(R.id.spinner);
        txtDATE = findViewById(R.id.editText_DATE);
        txtTIME = findViewById(R.id.editText_TIME);

        Intent intent = getIntent();
        ArrayList<String> danhSachMa = intent.getStringArrayListExtra("ID_LIST");
        ArrayList<String> danhSachTen = intent.getStringArrayListExtra("NAME_LIST");

        if(danhSachMa != null && danhSachTen != null) {
            for(int i = 0; i < danhSachMa.size(); i++) {
                arrTG.add(new TacGia(danhSachMa.get(i), danhSachTen.get(i)));
            }
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrTG);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        txtDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });
        
        txtTIME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonGio();
            }
        });
    }

    private void ChonGio() {
        int gio = calendar.get(calendar.HOUR);
        int phut = calendar.get(calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(0,0,0,i, i1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                txtTIME.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }

    private void ChonNgay() {
        int ngay = calendar.get(calendar.DATE);
        int thang = calendar.get(calendar.MONTH);
        int nam = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txtDATE.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}
