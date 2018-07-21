package com.example.studyroom.DetailPage;

/**
 * Created by hong on 2018-05-11.
 */

public class DetailPagePresenterImpl implements DetailPageContract.DetailPagePresenter,DetailPageModel.OnUserCheckListener{

    DetailPageContract.View  view;

    public DetailPagePresenterImpl(DetailPageContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void checkLoginUser() {
        DetailPageModel detailPageModel = new DetailPageModel(this);
        detailPageModel.userCheck();
    }

    @Override
    public void result(boolean isUser) {
        view.userResult(isUser);
    }
}
