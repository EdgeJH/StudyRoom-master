package com.example.studyroom.Auth.Register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studyroom.Auth.Impl.IRegisterActivity;
import com.example.studyroom.BaseActivity;
import com.example.studyroom.R;

import java.util.regex.Pattern;

public class RegisterEmailActivity extends BaseActivity implements IRegisterActivity {

    TextView emailErrTxt,pwdErrTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);
        this.initializeActivityElements();
    }

    @Override
    public void initializeActivityElements() {
        emailErrTxt = findViewById(R.id.email_err_txt);
        pwdErrTxt = findViewById(R.id.pwd_err_txt);
        findViewById(R.id.reg_email_next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.reg_input_email)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.reg_input_pwd)).getText().toString();

                if (!isValidEmail(email)) {
                    emailErrTxt.setText("이메일 양식을 확인해 주세요");
                } else if (!isValidPasswd(pwd)){
                    pwdErrTxt.setText("양식 : 영문자 숫자 혼합 특수문자 포함 8자 이상");
                } else {
                    Intent intent = new Intent(RegisterEmailActivity.this, RegisterPhoneValidActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("passwd", pwd);
                    startActivity(intent);
                }
            }
        });
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean isValidEmail(CharSequence email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private boolean isValidPasswd(String pw) {
        Pattern pattern = Pattern.compile( "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
        return (!pw.isEmpty()&&pattern.matcher(pw).matches());
    }


}
