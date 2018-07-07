package com.example.studyroom.Auth.Register;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.authmodule.module.PhoneValidModule;
import com.example.authmodule.module.abstraction.customer.PhoneValidListener;
import com.example.authmodule.module.abstraction.handler.AuthListenerHandler;
import com.example.studyroom.Auth.Impl.IRegisterActivity;
import com.example.studyroom.R;

public class RegisterPhoneValidActivity extends AppCompatActivity implements IRegisterActivity, PhoneValidListener {

    private boolean validPhone;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone_valid);
        this.initializeActivityElements();
    }

    @Override
    public void initializeActivityElements() {
        findViewById(R.id.reg_phone_sendkey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = ((EditText) findViewById(R.id.reg_phone_input_phone)).getText().toString();
                if(phoneNumber.isEmpty()) return;

                PhoneValidModule module = new PhoneValidModule();
                module.registerPhoneValidListener(getListener());
                AuthListenerHandler.getHandler().registerListener(module).run(phoneNumber,(Activity) RegisterPhoneValidActivity.this);
            }
        });
    }

    @Override
    public void authPhoneListener(String phoneNumber, boolean valid) {
        this.validPhone = valid;
        this.phoneNumber = phoneNumber;
        if(!this.validPhone) {
            android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(this);
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.setMessage("인증에 실패하였습니다.");
            alert.show();
            return;
        }else {
            this.setVerifyCode(phoneNumber);

            Intent intent = new Intent(RegisterPhoneValidActivity.this, RegisterCardActivity.class);
            intent.putExtra("email", (String) getIntent().getExtras().get("email"));
            intent.putExtra("passwd", (String) getIntent().getExtras().get("passwd"));
            intent.putExtra("phoneNumber", phoneNumber);
            startActivity(intent);
            finish();
        }
    }

    private void setVerifyCode(String smsCode)
    {
        EditText verifyEdit = findViewById(R.id.reg_phone_input_key);
        verifyEdit.setText(smsCode);
    }

    public PhoneValidListener getListener() { return this; }

}
