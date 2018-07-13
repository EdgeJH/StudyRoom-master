package com.example.studyroom;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by user1 on 2018-07-13.
 */

public class StudyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Typekit.getInstance()
                .add("bird_of_paradise",Typekit.createFromAsset(this, "bird_of_paradise.ttf"));

    }
}
