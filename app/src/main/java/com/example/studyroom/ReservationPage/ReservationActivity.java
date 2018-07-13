package com.example.studyroom.ReservationPage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.studyroom.BaseActivity;
import com.example.studyroom.Model.ReserveModel;

import com.example.studyroom.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ReservationActivity extends BaseActivity implements View.OnClickListener {

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    CollectionReference reference = firestore.collection("Reservation");
    ArrayList<ReserveModel> reservModels = new ArrayList<>();

    Button paymentBt, loadBt;
    EditText reservName, reservPhone, reservNum, reservInfo;
    TextView textReserveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        initView();

    }

    private void initView() {
        reservName = findViewById(R.id.reserv_name);
        reservPhone = findViewById(R.id.reserv_phone);
        reservNum = findViewById(R.id.reserv_num);
//        reservInfo = findViewById(R.id.reserv_info);

        textReserveInfo = findViewById(R.id.text_reserve);

        paymentBt = findViewById(R.id.payment_bt);
        loadBt = findViewById(R.id.load_bt);
        paymentBt.setOnClickListener(this);
        loadBt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.payment_bt:
                saveData();
                break;
            case R.id.load_bt:
                loadData();
//                ReadSingleContact();
                break;
        }
    }

    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if(task.isSuccessful()){
            QuerySnapshot snapshots = task.getResult();
            List<DocumentSnapshot> snapshotList = snapshots.getDocuments();
            for(DocumentSnapshot value : snapshotList){
                reservModels.add(value.toObject(ReserveModel.class));
            }

        }
    }

    private void saveData() {
        Map<String, Object> reserveInfo = new HashMap<>();
        reserveInfo.put("name", reservName.getText().toString());
        reserveInfo.put("phone", reservPhone.getText().toString());
        reserveInfo.put("num", reservNum.getText().toString());

//        firestore.collection("Reservation").document().set(reserveInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        });
        reference.add(reserveInfo)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("OK", "OKOKOKOKOKOK");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("FAIL", "FAILFAILFAILFAILFAIL");
                    }
                });
    }


    private void loadData() {
        reference.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
//                                ReservModel reservModel = document.toObject(ReservModel.class);
//                                reservModels.add(reservModel);

                                textReserveInfo.setText(document.getData().toString());

                            }
                        } else {
                            Log.d("FAIL", "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    private void ReadSingleContact() {
        DocumentReference user = firestore.collection("Reservation").document();
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("Name: ").append(doc.get("name"));
                    fields.append("\nNum: ").append(doc.get("num"));
                    fields.append("\nPhone: ").append(doc.get("phone"));
                    textReserveInfo.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }


}

