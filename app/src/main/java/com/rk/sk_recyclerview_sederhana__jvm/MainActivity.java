package com.rk.sk_recyclerview_sederhana__jvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rk.sk_recyclerview_sederhana__jvm.adapter.CardViewAdapter;
import com.rk.sk_recyclerview_sederhana__jvm.adapter.ListAdapter;
import com.rk.sk_recyclerview_sederhana__jvm.adapter.GridAdapter;
import com.rk.sk_recyclerview_sederhana__jvm.classmodel.Hero;
import com.rk.sk_recyclerview_sederhana__jvm.data.HeroesData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Hero> daftar2 = new ArrayList<>();

    private String judulActivity = "RizkyKhapidsyah";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        daftar2.addAll(HeroesData.dapatkanDaftarData());
        tampilkanRecyclerSecaraList();

        aturJudulActionBar("Mode List");
    }

    private void aturJudulActionBar(String judul) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(judul);
        }
    }

    private void tampilkanRecyclerSecaraList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(daftar2);
        rvHeroes.setAdapter(listAdapter);



    }

    private void tampilkanRecyclerSecaraGrid() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapter gridAdapter = new GridAdapter(daftar2);
        rvHeroes.setAdapter(gridAdapter);
    }

    private void tampilkanRecyclerSecaraCardView() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(daftar2);
        rvHeroes.setAdapter(cardViewAdapter);
    }

    private void tampilkanPahlawanYangDipilih(Hero pahlawan) {
        Toast.makeText(this, "Kamu Memilih " + pahlawan.getNama(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        aturMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void aturMode(int modePilih) {
        switch (modePilih) {
            case R.id.action_list:
                judulActivity = "Mode List";
                tampilkanRecyclerSecaraList();
                break;
            case R.id.action_grid:
                judulActivity = "Mode Grid";
                tampilkanRecyclerSecaraGrid();
                break;
            case R.id.action_cardview:
                judulActivity = "Mode CardView";
                tampilkanRecyclerSecaraCardView();
                break;
        }
        aturJudulActionBar(judulActivity);
    }
}