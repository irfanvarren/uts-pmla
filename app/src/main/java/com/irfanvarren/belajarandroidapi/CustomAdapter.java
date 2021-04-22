package com.irfanvarren.belajarandroidapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.irfanvarren.belajarandroidapi.model.User;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

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

        private TextView usernameView;

        CustomViewHolder(View itemView){
            super(itemView);
            mView = itemView;
            usernameView = mView.findViewById(R.id.username);
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
        holder.usernameView.setText(dataList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
