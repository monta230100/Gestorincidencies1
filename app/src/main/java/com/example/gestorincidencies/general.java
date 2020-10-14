package com.example.gestorincidencies;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import data.Incidencia;

public class general extends AppCompatActivity {
    ArrayList<Incidencia> incidencies = new ArrayList<Incidencia>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        final Button afegir = findViewById(R.id.afegir);
        afegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goToAfegir();
            }
        });
        final Button llistar = findViewById(R.id.llistar);
        llistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goToLlistar();
            }
        });
        final Button eliminar = findViewById(R.id.eliminar);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                incidencies.clear();
                Toast.makeText(getApplicationContext(), "S'han eliminat totes les incidències.", Toast.LENGTH_SHORT).show();
            }
        });
        final Button help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(general.this, help.class));
            }
        });
    }

    private void goToAfegir() {
        Intent afegir = new Intent(this, afegir.class);
        afegir.putExtra("incidencies", incidencies);
        startActivityForResult(afegir, 1);

    }
    private void goToLlistar() {
        Intent llistar = new Intent(this, llistar.class);
        llistar.putExtra("incidencies", incidencies);
        startActivity(llistar);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                incidencies = (ArrayList<Incidencia>) data.getSerializableExtra("Incidencia");
            }
        }
    }
}