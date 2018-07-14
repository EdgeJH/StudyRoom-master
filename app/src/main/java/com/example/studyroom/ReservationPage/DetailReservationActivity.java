package com.example.studyroom.ReservationPage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyroom.Model.ReserveCompanyModel;
import com.example.studyroom.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class DetailReservationActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    CollectionReference reference = firestore.collection("Reservation");
    DocumentReference documentReference = reference.document("0");
    ArrayList<ReserveCompanyModel> reservModels = new ArrayList<>();

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
                break;
        }
    }

//    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//        if(task.isSuccessful()){
//            QuerySnapshot snapshots = task.getResult();
//            List<DocumentSnapshot> snapshotList = snapshots.getDocuments();
//            for(DocumentSnapshot value : snapshotList){
//                reservModels.add(value.toObject(ReserveCompanyModel.class));
//            }
//
//        }
//    }

    private void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences("RoomInfo", MODE_PRIVATE);
        final String roomName = sharedPreferences.getString("companyName", "");

        final Map<String, Object> reserveInfo = new HashMap<>();
        reserveInfo.put("name", reservName.getText().toString());
        reserveInfo.put("phone", reservPhone.getText().toString());
        reserveInfo.put("num", reservNum.getText().toString());

        firestore.collection("Reservation").document("0").set(reserveInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                firestore.collection("Company").document("0").set(reserveInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });

                firestore.collection("User").document("0").set(reserveInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });

            }
        });

    }



    private void loadData() {
//        firestore.collection("Reservation").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (DocumentSnapshot document : task.getResult()) {
////                                ReservModel reservModel = document.toObject(ReservModel.class);
////                                reservModels.add(reservModel);
//
//                                Log.d("asdasdasd", document.getData().toString());
//
//
////                                textReserveInfo.setText(document.getData().toString());
//
//
//                            }
//                        } else {
//                            Log.d("FAIL", "Error getting documents.", task.getException());
//                        }
//                    }
//                });



        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    Toast.makeText(DetailReservationActivity.this, "데이터 가져오기 성공", Toast.LENGTH_SHORT).show();
                    Log.d("asdasdasd", documentSnapshot.getData().toString());
                }
            }
        });

    }


}

