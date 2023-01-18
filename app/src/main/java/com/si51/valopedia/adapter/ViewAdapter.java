package com.si51.valopedia.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.si51.valopedia.R;
import com.si51.valopedia.models.ValorantData;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.DataViewHolder>{
    private ArrayList<ValorantData> dataModelsArrayList;

    public ViewAdapter(ArrayList<ValorantData> dataModelsArrayList) {
        this.dataModelsArrayList = dataModelsArrayList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        ValorantData dataModel = dataModelsArrayList.get(position);

        holder.tvName.setText(dataModel.getJudul());
        holder.tvKeterangan.setText(dataModel.getKeterangan());
        holder.tvVideoid.setText(dataModel.getVideoid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String judul = dataModelsArrayList.get(holder.getBindingAdapterPosition()).getJudul();
                String keterangan = dataModelsArrayList.get(holder.getBindingAdapterPosition()).getKeterangan();
                String videoid = dataModelsArrayList.get(holder.getBindingAdapterPosition()).getVideoid();

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("varJudul", judul);
                intent.putExtra("varKeterangan", keterangan);
                intent.putExtra("varVideoid", videoid);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelsArrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvDescription, tvCharImg, tvBackground;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv);
            tvDescription = itemView.findViewById(R.id.tv_keterangan);
            tvCharImg = itemView.findViewById(R.id.tv_videoid);
            tvBackground = itemView.findViewById(R.id.tv_videoid);

        }
    }

}
