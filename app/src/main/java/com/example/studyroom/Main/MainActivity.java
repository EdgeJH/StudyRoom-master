package com.example.studyroom.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.studyroom.Main.UserPackage.AccountFragment;
import com.example.studyroom.Model.CompanyModel;
import com.example.studyroom.R;
import com.example.studyroom.ReservationPage.ReservationFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    Menu bottomMenu;
    ViewPagerFragment adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setViewPager();
        setBottomNavigationView();


//        reference.get().addOnCompleteListener(this);
//        OnCompleteListener<QuerySnapshot>

    }

//
//    @Override
//    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//        if (task.isSuccessful()) {
//            QuerySnapshot snapshots = task.getResult();
//            List<DocumentSnapshot> snapshotList = snapshots.getDocuments();
//            for (DocumentSnapshot value : snapshotList) {
//                companyModels.add(value.toObject(CompanyModel.class));
//            }
//        }
//    }

    private void initView(){
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bt_nav);
    }

    private void setBottomNavigationView(){
        bottomMenu = bottomNavigationView.getMenu();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void setViewPager(){
        adapter = new ViewPagerFragment(getSupportFragmentManager());
        adapter.addFragment(new MainFragment());
        adapter.addFragment(new ReservationFragment());
        adapter.addFragment(new AccountFragment());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bt_nav_info:
                viewPager.setCurrentItem(0);
                break;
            case R.id.bt_nav_reserve:
                viewPager.setCurrentItem(1);
                break;
            case R.id.bt_nav_account:
                viewPager.setCurrentItem(2);
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomMenu.getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
