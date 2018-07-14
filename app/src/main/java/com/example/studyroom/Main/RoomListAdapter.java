package com.example.studyroom.Main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studyroom.Model.CompanyModel;
import com.example.studyroom.R;
import com.example.studyroom.ReservationPage.DetailReservationActivity;

import java.util.ArrayList;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.ViewHolder> {

    ArrayList<CompanyModel> companyModels = new ArrayList<>();
    Context context;


    public RoomListAdapter(ArrayList<CompanyModel> companyModels, Context context) {
        this.companyModels = companyModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.roomlist_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CompanyModel item = companyModels.get(position);
        holder.roomImage.setImageResource(item.getRoomImage());
        holder.companyName.setText(item.getCompanyName());


    }

    @Override
    public int getItemCount() {
        return companyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout roomItem;
        ImageView roomImage;
        TextView companyName;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            initView(itemView);

        }

        private void initView(View view){
            roomItem = itemView.findViewById(R.id.room_Item);
            roomImage = itemView.findViewById(R.id.room_Image);
            companyName = itemView.findViewById(R.id.company_name);

            roomItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            SharedPreferences sharedPreferences = context.getSharedPreferences("RoomInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("companyName", companyName.getText().toString());
            editor.apply();

            Intent intent = new Intent(context, DetailReservationActivity.class);
            context.startActivity(intent);

        }
    }
}
