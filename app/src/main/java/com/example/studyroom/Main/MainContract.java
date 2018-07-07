package com.example.studyroom.Main;

import com.example.studyroom.BasePresenter;
import com.example.studyroom.BaseView;

/**
 * Created by hong on 2018-05-11.
 */

public interface MainContract {
    interface MainPresenter extends BasePresenter {

    }

    interface View extends BaseView<MainPresenter> {

    }
}
