package com.example.studyroom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by user1 on 2018-07-13.
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
