package com.example.studyroom.Auth.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.studyroom.Auth.Impl.IRegisterActivity;
import com.example.studyroom.R;

public class RegisterEmailActivity extends AppCompatActivity implements IRegisterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);
        this.initializeActivityElements();
    }

    @Override
    public void initializeActivityElements() {
        findViewById(R.id.reg_email_next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.reg_input_email)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.reg_input_pwd)).getText().toString();

                if(email.isEmpty() || pwd.isEmpty()) return;
                Intent intent = new Intent(RegisterEmailActivity.this, RegisterPhoneValidActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("passwd", pwd);
                startActivity(intent);
             }
        });
    }

}
