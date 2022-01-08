package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Bai1 extends AppCompatActivity {
    TextInputEditText tieNumber1,tieNumber2;
    TextView tvBai1;
    Button btnTong, btnHieu, btnTich, btnThuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        Toast.makeText(this, "Dang tao", Toast.LENGTH_SHORT).show();
        Log.d("test", "onCreate()");

        initMapping();
        tinhTong();
        tinhHieu();
        tinhTich();
        tinhThuong();
    }

    private void initMapping(){
        tieNumber1 = findViewById(R.id.tieNumber1);
        tieNumber2 = findViewById(R.id.tieNumber2);
        tvBai1 = findViewById(R.id.tvBai1);
    }

    Double number1,number2,number3;
    Intent intent;
    public void createIntent(Context context,Class contextClass){
        intent = new Intent(context,contextClass);
        number1 = Double.parseDouble(tieNumber1.getText().toString());
        number2 = Double.parseDouble(tieNumber2.getText().toString());
    }

    public void tinhTong() {
        btnTong = findViewById(R.id.btnTong);
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(Bai1.this,Bai2.class);
                number3 = number1 + number2;
                intent.putExtra("Tong", number3);
                startActivityForResult(intent, 999);
//                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 999 && resultCode == RESULT_OK) {
//            Double number = data.getExtras().getDouble("Tong");
////            Double number = data.getExtras().getDouble("Tong");
//            tvBai1.append("Tong = " + String.valueOf(number));
//        } else if (requestCode == 999 && resultCode == RESULT_CANCELED) {
//            Double number = data.getExtras().getDouble("Tong");
//            tvBai1.append("");
//        }
//
//        if (requestCode == 777 && resultCode == RESULT_OK) {
//            Double number = data.getExtras().getDouble("Hieu");
//            tvBai1.append(",Hieu = " + String.valueOf(number));
//        } else if (requestCode == 777 && resultCode == RESULT_CANCELED) {
//            Double number = data.getExtras().getDouble("Hieu");
//            tvBai1.append("");
//        }
//
//        if (requestCode == 666 && resultCode == RESULT_OK) {
//            Double number = data.getExtras().getDouble("Tich");
//            tvBai1.append(",Tich = " + String.valueOf(number));
//        } else if (requestCode == 666 && resultCode == RESULT_CANCELED) {
//            Double number = data.getExtras().getDouble("Tich");
//            tvBai1.append("");
//        }

        useRequestCode(requestCode,resultCode,data,999,"Tong");
        useRequestCode(requestCode,resultCode,data,777,"Hieu");
        useRequestCode(requestCode,resultCode,data,666,"Tich");
        useRequestCode(requestCode,resultCode,data,555,"Thuong");
    }

    @SuppressLint("ResourceAsColor")
    public void useRequestCode(int requestCode, int resultCode, @Nullable Intent data, Integer valueRequestCode, String key){
        if (requestCode == valueRequestCode && resultCode == RESULT_OK) {
            Double number = data.getExtras().getDouble(key);
            tvBai1.append(key+ " = " + String.valueOf(number)+"\n");
            tvBai1.setTextColor(R.color.teal_200);
        } else if (requestCode == 555 && resultCode == RESULT_CANCELED) {
//            Double number = data.getExtras().getDouble(key);
            tvBai1.append("");
        }
    }

    public void tinhHieu() {
        btnHieu = findViewById(R.id.btnHieu);
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(Bai1.this,Bai3.class);
                number3 = number1 - number2;
                intent.putExtra("Hieu", number3);
                startActivityForResult(intent, 777);
//                startActivity(intent);
            }
        });
    }

    public void tinhTich() {
        btnTich = findViewById(R.id.btnTich);
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(Bai1.this,Bai4.class);
                number3 = number1 * number2;
                intent.putExtra("Tich", number3);
                startActivityForResult(intent, 666);
//                startActivity(intent);
            }
        });
    }

    public void tinhThuong() {
        btnThuong = findViewById(R.id.btnThuong);
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createIntent(Bai1.this,Bai5.class);
                number3 = number1 / number2;
                intent.putExtra("Thuong", number3);
                startActivityForResult(intent, 555);
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Dang chay", Toast.LENGTH_SHORT).show();
        Log.d("test", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Tiep tuc chay", Toast.LENGTH_SHORT).show();
        Log.d("test", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Tam dung lai", Toast.LENGTH_SHORT).show();
        Log.d("test", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Dung lai", Toast.LENGTH_SHORT).show();
        Log.d("test", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Pha huy ", Toast.LENGTH_SHORT).show();
        Log.d("test", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Khoi dong lai", Toast.LENGTH_SHORT).show();
        Log.d("test", "onRestart()");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}