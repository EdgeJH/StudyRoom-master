package com.example.studyroom.ReservationPage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studyroom.R;

/**
 * Created by hong on 2018-05-11.
 */

public class ReservationFragment extends Fragment implements ReservationContract.View {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_reservation, container, false);

        return view;
    }

    @Override
    public void setPresenter(ReservationContract.ReservationPresenter presenter) {

    }
}
