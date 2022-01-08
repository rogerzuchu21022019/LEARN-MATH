package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity {
    TextView tv;
    Button btn;
    Double number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        tv = findViewById(R.id.tvResult4);
        btn = findViewById(R.id.btnBai4);
        number = getIntent().getExtras().getDouble("Tich", 5);
        tv.setText(String.valueOf(number));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }

    public void createDialog() {
        AlertDialog.Builder notification = new AlertDialog.Builder(this);
        notification.setTitle("Thong Bao");
        notification.setIcon(R.mipmap.ic_launcher);
        notification.setMessage("Ban có muốn chọn coca thêm vào món ăn không?");
        notification.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("Tich", number);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
        });
        notification.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("Tich", number);
                        setResult(RESULT_CANCELED, intent);
                        finish();
                    }
                });
            }
        });
        notification.show();
    }
}