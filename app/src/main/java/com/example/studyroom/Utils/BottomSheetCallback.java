package com.example.studyroom.Utils;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.ImageView;

public class BottomSheetCallback extends BottomSheetBehavior.BottomSheetCallback {
    ImageView shadow;

    public BottomSheetCallback(ImageView shadow) {
        this.shadow = shadow;
    }

    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {
        if (newState == BottomSheetBehavior.STATE_HIDDEN){
            shadow.setVisibility(View.GONE);
        } else {
            shadow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }
}
