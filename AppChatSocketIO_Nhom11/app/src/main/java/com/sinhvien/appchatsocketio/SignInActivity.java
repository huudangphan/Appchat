package com.sinhvien.appchatsocketio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private Button btnSignIn;
    private TextView tvRegister;

    private void Init() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvRegister = findViewById(R.id.tvRegister);
    }

    private View.OnClickListener tvRegisterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        }
    };
   

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Init();
//        tvRegister.setOnClickListener(tvRegisterOnClickListener);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtUsername.getText().toString().isEmpty()||edtPassword.getText().toString().isEmpty())
                {
                    edtUsername.setError("Name or password not null");

                }
                else{
                    Intent intent =new Intent(SignInActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }



    public boolean IsEmpty(String s)
    {
        if(s==" ")
            return true;
        else
            return  false;

    }

}
