package com.example.studyroom.Auth.Register;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.authmodule.module.activityutils.TaskCallback;
import com.example.authmodule.module.factory.AuthModuleFactory;
import com.example.authmodule.module.factory.AuthType;
import com.example.studyroom.Auth.Impl.IRegisterActivity;
import com.example.studyroom.BaseActivity;
import com.example.studyroom.R;

public class RegisterCardActivity extends BaseActivity implements IRegisterActivity, TaskCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_card);
    }

    @Override
    public void initializeActivityElements() {
        findViewById(R.id.reg_card_clear_btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = (String) getIntent().getExtras().get("email");
                String passwd = (String) getIntent().getExtras().get("passwd");
                String phoneNumber = (String) getIntent().getExtras().get("phoneNumber");
                String card = "xxxx-xxxx-xxxx-xxxx";

                AuthModuleFactory.getFactory().runAuthModule(RegisterCardActivity.this, AuthType.EMAIL_REGISTER, email, passwd, phoneNumber, card);
            }
        });
    }

    @Override
    public void taskFinish(boolean succss) {
        if(succss) {
            /* 메인 페이지로 넘어감 */
        }
    }

    @Override
    public Context getContext() { return this; }

}
