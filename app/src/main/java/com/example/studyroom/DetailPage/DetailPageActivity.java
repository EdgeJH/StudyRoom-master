package com.example.studyroom.DetailPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.studyroom.BaseActivity;
import com.example.studyroom.R;

public class DetailPageActivity extends BaseActivity {

    ImageView pc, wifi, board, watertank, parking, projector, print;
    boolean pcCheck, wifiCheck, boardCheck, watertankCheck, parkingCheck, projectorCheck, printCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        initView();

    }

    private void initView(){
        pc = findViewById(R.id.pc);
        wifi = findViewById(R.id.wifi);
        board = findViewById(R.id.board);
        watertank = findViewById(R.id.watertank);
        parking = findViewById(R.id.parking);
        projector = findViewById(R.id.projector);
        print = findViewById(R.id.print);

    }

    private void companyBooleanModelCheck(){



    }


}
