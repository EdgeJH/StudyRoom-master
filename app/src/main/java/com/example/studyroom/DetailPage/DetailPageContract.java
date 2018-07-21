package com.example.studyroom.DetailPage;

import com.example.studyroom.BasePresenter;
import com.example.studyroom.BaseView;

/**
 * Created by hong on 2018-05-11.
 */

public interface DetailPageContract {
    interface DetailPagePresenter extends BasePresenter {
        void checkLoginUser();
    }

    interface View extends BaseView<DetailPagePresenter> {
        void userResult(boolean isUser);
    }
}
