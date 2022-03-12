package com.rk.sk_recyclerview_sederhana__jvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rk.sk_recyclerview_sederhana__jvm.R;
import com.rk.sk_recyclerview_sederhana__jvm.classmodel.Hero;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private ArrayList<Hero> daftarPahlawan;

    public GridAdapter(ArrayList<Hero> daftar) {
        this.daftarPahlawan = daftar;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tampil = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero, parent, false);
        return new GridViewHolder(tampil);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(daftarPahlawan.get(position).getFoto()).apply(new RequestOptions().override(350, 550)).into(holder.IV_imgPhoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + daftarPahlawan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return daftarPahlawan.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView IV_imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
