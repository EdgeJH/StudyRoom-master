package com.example.studyroom.Auth.Register;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.authmodule.module.PhoneValidModule;
import com.example.authmodule.module.abstraction.customer.PhoneValidListener;
import com.example.authmodule.module.abstraction.handler.AuthListenerHandler;
import com.example.studyroom.Auth.Impl.IRegisterActivity;
import com.example.studyroom.BaseActivity;
import com.example.studyroom.R;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.HintRequest;

public class RegisterPhoneValidActivity extends BaseActivity implements IRegisterActivity, PhoneValidListener {

    private boolean validPhone;
    private String phoneNumber;
    private static final int RESOLVE_HINT =99;
    private EditText regPhoneInput;
    private CredentialsClient mCredentialsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone_valid);
        this.initializeActivityElements();
        requestHint();
    }

    @Override
    public void initializeActivityElements() {
        mCredentialsClient = Credentials.getClient(this);

        regPhoneInput =findViewById(R.id.reg_phone_input_phone);
        findViewById(R.id.reg_phone_sendkey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber =regPhoneInput.getText().toString();
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

    private void requestHint() {
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent intent = mCredentialsClient.getHintPickerIntent(hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(),
                    RESOLVE_HINT, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                regPhoneInput.setText(credential.getId());
            }
        }
    }

}
