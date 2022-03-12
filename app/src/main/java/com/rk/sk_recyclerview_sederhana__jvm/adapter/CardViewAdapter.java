package com.rk.sk_recyclerview_sederhana__jvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rk.sk_recyclerview_sederhana__jvm.R;
import com.rk.sk_recyclerview_sederhana__jvm.classmodel.Hero;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CV_ViewHolder> {
    private ArrayList<Hero> daftarPahlawan;

    public CardViewAdapter(ArrayList<Hero> daftar) {
        this.daftarPahlawan = daftar;
    }

    @NonNull
    @Override
    public CardViewAdapter.CV_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lihat = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_hero, parent, false);
        return new CV_ViewHolder(lihat);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewAdapter.CV_ViewHolder holder, int position) {
        Hero pahlawan = daftarPahlawan.get(position);
        Glide.with(holder.itemView.getContext()).load(pahlawan.getFoto()).apply(new RequestOptions().override(350, 550)).into(holder.IV_ImgFoto);

        holder.tvName.setText(pahlawan.getNama());
        holder.tvDetail.setText(pahlawan.getRincian());
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite" + daftarPahlawan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " + daftarPahlawan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
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

    public class CV_ViewHolder extends RecyclerView.ViewHolder {
        ImageView IV_ImgFoto;
        TextView tvName, tvDetail;
        Button btnFavorite, btnShare;

        public CV_ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_ImgFoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }

}
