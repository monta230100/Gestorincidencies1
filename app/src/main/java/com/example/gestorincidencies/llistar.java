package com.example.gestorincidencies;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestorincidencies.RecyclerViewAdapter;

import java.util.ArrayList;

import data.Incidencia;

public class llistar extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<Incidencia> incidencies = new ArrayList<Incidencia>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistar);

        Intent recogerDatos = getIntent();
        incidencies = (ArrayList<Incidencia>) recogerDatos.getSerializableExtra("Incidencia");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }
}
