package com.longkhoa.myapplication.View;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.longkhoa.myapplication.Presenter.PresenterXuLyDangNhap;
import com.longkhoa.myapplication.R;

public class MainActivity extends AppCompatActivity implements ViewXuLyDangNhap {
    EditText edtuser, edtpass;
    Button button;
    private FirebaseAuth firebaseAuth;
    final PresenterXuLyDangNhap presenterXuLyDangNhap = new PresenterXuLyDangNhap(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        firebaseAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user = edtuser.getText().toString();
                final String pass = edtpass.getText().toString();
                presenterXuLyDangNhap.ktDangNhap(user, pass);
            }
        });
    }

    private void anhXa() {
        edtpass = findViewById(R.id.edtpass);
        edtuser = findViewById(R.id.edtuser);
        button = findViewById(R.id.btnlogin);
    }

    @Override
    public void dangNhapThanhCong() {
        Toast.makeText(MainActivity.this, "Thành Công", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Main3Activity.class));
    }

    @Override
    public void dangNhapThatBai() {
        Toast.makeText(MainActivity.this, "Đăng Ký Lại Tài khoản", Toast.LENGTH_SHORT).show();
    }
}
