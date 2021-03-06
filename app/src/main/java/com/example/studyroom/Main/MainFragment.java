package com.example.studyroom.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.studyroom.Model.CompanyModel;
import com.example.studyroom.R;
import com.example.studyroom.Utils.BottomSheetCallback;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by hong on 2018-05-11.
 */

public class MainFragment extends Fragment implements MainContract.View, View.OnClickListener, TextWatcher, TextView.OnEditorActionListener {

    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private CollectionReference reference = firestore.collection("Company");
    private ArrayList<CompanyModel> companyModels = new ArrayList<>();
    private ImageView searchBt, resetBt,shadow;
    private EditText searchEdit;
    private BottomSheetBehavior bottomSheetBehavior;
    private RelativeLayout bottomSheet;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main, container, false);
        initView(view);
        return view;
    }


    @Override
    public void setPresenter(MainContract.MainPresenter presenter) {

    }

    private void initView(View view) {
        searchBt = view.findViewById(R.id.search_bt);
        resetBt = view.findViewById(R.id.reset_bt);
        searchEdit = view.findViewById(R.id.search_edit);
        bottomSheet = view.findViewById(R.id.bottom_sheet);
        shadow = view.findViewById(R.id.shadow);


        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetCallback(shadow));

        searchBt.setOnClickListener(this);
        resetBt.setOnClickListener(this);
        searchEdit.setOnEditorActionListener(this);
        searchEdit.addTextChangedListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_bt:
                switch (bottomSheetBehavior.getState()) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        break;


                }
                break;
            case R.id.reset_bt:
                searchEdit.setText("");
                resetBt.setVisibility(View.INVISIBLE);
                break;
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() > 0) {
            resetBt.setVisibility(View.VISIBLE);
        } else {
            resetBt.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId) {
            case EditorInfo.IME_ACTION_SEARCH:
                ((InputMethodManager) getActivity().getApplicationContext()
                        .getSystemService(INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(searchEdit.getWindowToken(), 0);
                break;

        }
        return false;
    }
}
