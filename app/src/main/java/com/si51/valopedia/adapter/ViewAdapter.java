package com.si51.valopedia.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.si51.valopedia.R;
import com.si51.valopedia.models.ValorantData;
import com.si51.valopedia.models.ValorantDetail;
import com.si51.valopedia.models.ValorantModel;
import com.si51.valopedia.services.ItemClickListener;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.DataViewHolder>{
    private ValorantData result = new ValorantData();
    private ItemClickListener<ValorantModel> itemClickListener;
    private ValorantData results;

    public ViewAdapter(ItemClickListener<ValorantModel> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(ValorantData results){
        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();

        holder.tvName.setText(results.getResults().get(pos).getDisplayName());
        //holder.tvDescription.setText(dataModel.getDescription());
//        holder.tvCharImg.setText(dataModel.getVideoid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(results.getResults().get(pos), pos );
            }
        }
        );
    }

    @Override
    public int getItemCount() {
        return results.getResults().size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView imgChar;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            imgChar = itemView.findViewById(R.id.img_char);

        }
    }

}
