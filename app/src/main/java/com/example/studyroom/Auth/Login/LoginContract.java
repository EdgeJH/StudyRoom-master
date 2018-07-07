package com.example.studyroom.Auth.Login;

import com.example.studyroom.BasePresenter;
import com.example.studyroom.BaseView;

/**
 * Created by hong on 2018-05-11.
 */

public interface LoginContract {
    interface LoginPresenter extends BasePresenter {

        void googleLogin();

        void onActivityResult(int requestCode, int resultCode, int data);
    }

    interface View extends BaseView<LoginPresenter>{

    }
}
