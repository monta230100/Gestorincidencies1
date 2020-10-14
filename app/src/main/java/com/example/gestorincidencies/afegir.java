package com.example.gestorincidencies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import data.Incidencia;

public class afegir extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    ArrayList<Incidencia> incidencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir);

        Intent recogerDatos = getIntent();


        incidencies = (ArrayList<Incidencia>) recogerDatos.getSerializableExtra("Incidencia");

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Urgencia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Button guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Incidencia incidencia = new Incidencia();
                EditText nom = findViewById(R.id.titol);
                String nombre = nom.getText().toString();
                incidencia.nom = nombre;
                incidencia.prioritat = nivell;

                incidencies.add(incidencia);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("incidencies", incidencies);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
    String nivell;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        nivell = text;
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}