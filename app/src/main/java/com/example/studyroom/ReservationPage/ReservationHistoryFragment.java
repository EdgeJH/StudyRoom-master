package com.example.studyroom.ReservationPage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studyroom.Model.CompanyModel;
import com.example.studyroom.Model.ReserveHistoryModel;
import com.example.studyroom.Model.ReserveModel.ReserveToUserModel;
import com.example.studyroom.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

/**
 * Created by hong on 2018-05-11.
 */

public class ReservationHistoryFragment extends Fragment implements ReservationContract.View {

    private RecyclerView recyclerView;
    private ReservationHistoryAdapter adapter;
    private ArrayList<ReserveHistoryModel> reserveHistoryModels = new ArrayList<>();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseUser user = auth.getCurrentUser();
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference;
    private String userKey, companyKey;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_reservation, container, false);

        initView(view);
        setRecyclerView();

        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler);

    }

    private void setRecyclerView() {
        adapter = new ReservationHistoryAdapter(reserveHistoryModels, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void setPresenter(ReservationContract.ReservationPresenter presenter) {

    }



    private void loadData() {
        userKey = user.getUid();
        //companyKey

        collectionReference = firebaseFirestore.collection("User").document(userKey).collection(companyKey);

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot documentSnapshots) {
                for (DocumentSnapshot value : documentSnapshots) {
                    reserveHistoryModels.add(value.toObject(ReserveHistoryModel.class));


                }

            }
        });
    }

}
