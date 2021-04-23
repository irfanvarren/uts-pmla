package com.irfanvarren.belajarandroidapi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.irfanvarren.belajarandroidapi.model.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
    private List<User> dataList;
    private Context context;

    public CustomAdapter(Context context, List<User> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        private MaterialCardView cardView;
        private TextView nameView;
        private Button profileView;
        private User currentUser;

        CustomViewHolder(View itemView){
            super(itemView);
            mView = itemView;
            cardView = mView.findViewById(R.id.card);
            nameView = mView.findViewById(R.id.name);
            profileView = mView.findViewById(R.id.profile);
            if(dataList == null){
                Toast.makeText(context, "Data api kosong / null", Toast.LENGTH_SHORT);
            }
        }
    }

    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
        if(dataList != null) {
            User currentUser = dataList.get(position);
            String name = currentUser.getName();
            String initial = String.valueOf(name.charAt(0));
            holder.nameView.setText(name);
            holder.profileView.setText(initial);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "onClick: test");
                    Toast.makeText(context, currentUser.getEmail(), Toast.LENGTH_SHORT);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(dataList != null) {
            return dataList.size();
        }
        return 0;
    }
}
