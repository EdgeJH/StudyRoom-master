package com.example.studyroom.Auth.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.authmodule.module.activityutils.TaskCallback;
import com.example.authmodule.module.factory.AuthModuleFactory;
import com.example.authmodule.module.factory.AuthType;
import com.example.studyroom.Auth.Register.RegisterEmailActivity;
import com.example.studyroom.Main.MainActivity;
import com.example.studyroom.R;

public class LoginActivity extends AppCompatActivity implements TaskCallback {

    private EditText emailEdit,pwdEdit;
    private Button loginBt;
    private TextView registerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        this.emailEdit = findViewById(R.id.reg_email);
        this.pwdEdit = findViewById(R.id.reg_passwd);
        this.loginBt = findViewById(R.id.reg_loginbtn);
        this.registerTv = findViewById(R.id.reg_regtv);

        this.registerEvents();
    }

    private void registerEvents() {
        this.loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = LoginActivity.this.emailEdit.getText().toString();
                String passwd = LoginActivity.this.pwdEdit.getText().toString();

                if(email.equals("") || passwd.equals("")) { return; }
                LoginActivity.this.login(email, passwd);
            }
        });

        this.registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterEmailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void taskFinish(boolean isSuccess) {
        if (isSuccess){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this,"로그인에 실패하였습니다.",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
    private void login(String email,String pwd){ AuthModuleFactory.getFactory().runAuthModule(this, AuthType.LOGIN, email,pwd); }

}
