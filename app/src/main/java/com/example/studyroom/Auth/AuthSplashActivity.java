package com.example.studyroom.Auth;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.authmodule.module.activityutils.TaskCallback;
import com.example.authmodule.module.factory.AuthModuleFactory;
import com.example.authmodule.module.factory.AuthType;
import com.example.studyroom.Auth.Login.LoginActivity;
import com.example.studyroom.Auth.Utility.AuthFileManager;
import com.example.studyroom.Main.MainActivity;
import com.example.studyroom.R;

public class AuthSplashActivity extends AppCompatActivity implements TaskCallback{

    private boolean authSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_splash);

        try {
            AuthFileManager.getFileMnager().initialize(AuthSplashActivity.this);
            if(AuthFileManager.getFileMnager().isWrited()) {
                /* 자동로그인 */
                AuthModuleFactory.getFactory().runAuthModule(this, AuthType.LOGIN, AuthFileManager.getFileMnager().get("id"),
                        AuthFileManager.getFileMnager().get("pwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                if (AuthFileManager.getFileMnager().isWrited() && authSuccess)
                    intent = new Intent(AuthSplashActivity.this, MainActivity.class);
                else intent = new Intent(AuthSplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500L);
    }

    @Deprecated
    public void taskFinish(boolean success) {
        this.authSuccess = success;
    }

    @Override
    public Context getContext() {
        return this;
    }


}
