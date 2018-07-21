package com.example.studyroom.DetailPage;

import android.text.TextUtils;

import com.example.studyroom.Auth.Utility.AuthFileManager;

/**
 * Created by hong on 2018-05-11.
 */

public class DetailPageModel  {

    OnUserCheckListener onUserCheckListener;

    public DetailPageModel(OnUserCheckListener onUserCheckListener) {
        this.onUserCheckListener = onUserCheckListener;
    }

    public void userCheck(){
        if (!TextUtils.isEmpty(AuthFileManager.getFileMnager().get("id"))){
            onUserCheckListener.result(true);
        } else {
            onUserCheckListener.result(false);
        }
    }

    interface OnUserCheckListener{
        void result(boolean isUser);
    }
}
