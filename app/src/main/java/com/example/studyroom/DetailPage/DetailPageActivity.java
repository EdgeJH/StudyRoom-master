package com.example.studyroom.DetailPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.studyroom.Auth.Login.LoginActivity;
import com.example.studyroom.BaseActivity;
import com.example.studyroom.Model.CompanyModel;
import com.example.studyroom.R;

import me.relex.circleindicator.CircleIndicator;

public class DetailPageActivity extends BaseActivity implements View.OnClickListener ,DetailPageContract.View{
    private ViewPager viewPager;
    private DetailPagerAdapter pagerAdapter;
    private CompanyModel companyModel;
    private CircleIndicator indicator;
    private FloatingActionButton reservFab;
    private DetailPagePresenterImpl presenterImpl;
    private DetailPageContract.DetailPagePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterImpl = new DetailPagePresenterImpl(this);
        setContentView(R.layout.activity_detail_page);
        getData();
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        pagerAdapter  = new DetailPagerAdapter(this,companyModel.getRoomImage());
        indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        reservFab = findViewById(R.id.reserv_fab);
        reservFab.setOnClickListener(this);
    }

    public void getData(){
        companyModel = (CompanyModel) getIntent().getSerializableExtra("comPany");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reserv_fab:
                presenter.checkLoginUser();
                break;
        }
    }

    @Override
    public void userResult(boolean isUser) {
        if (isUser){
            //TODO 예약페이지 intent
        } else {
            intent(LoginActivity.class);
        }
    }

    @Override
    public void setPresenter(DetailPageContract.DetailPagePresenter presenter) {
        this.presenter  =presenter;
    }

    private  <T> void  intent(Class<T> targetActivity){
        Intent intent = new Intent(this,targetActivity);
        startActivity(intent);
    }
}
