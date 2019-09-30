package com.example.ontapgk_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnThemTacGia, btnDSTacGia, btnQuanLyTacGia, btnXoaTrang, btnLuuTacGia;
    EditText txtMaTacGia, txtTenTacGia;
    Dialog dialog;
    ArrayList<String> idList = new ArrayList<>(), nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnThemTacGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        btnDSTacGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DSTacGia_Activity.class);
                intent.putStringArrayListExtra("ID_LIST", idList);
                intent.putStringArrayListExtra("NAME_LIST", nameList);
                startActivity(intent);
            }
        });

        btnLuuTacGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = txtMaTacGia.getText().toString();
                String ten = txtTenTacGia.getText().toString();

                idList.add(ma);
                nameList.add(ten);
            }
        });

        btnQuanLyTacGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QuanLyTacGia.class);
                intent.putStringArrayListExtra("ID_LIST", idList);
                intent.putStringArrayListExtra("NAME_LIST", nameList);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        dialog = new Dialog(this);
        dialog.setTitle("Thêm mới tác giả");
        dialog.setContentView(R.layout.themtacgia_dialog);

        btnThemTacGia = findViewById(R.id.button_ThemTacGia);
        btnDSTacGia = findViewById(R.id.button_XemDSTacGia);
        btnQuanLyTacGia = findViewById(R.id.button_QuanLySach);
        txtMaTacGia = dialog.findViewById(R.id.txtMaTacGia);
        txtTenTacGia = dialog.findViewById(R.id.txtTenTacGia);
        btnXoaTrang = dialog.findViewById(R.id.btnXoaTrang);
        btnLuuTacGia = dialog.findViewById(R.id.btnLuuTacGia);
    }
}
