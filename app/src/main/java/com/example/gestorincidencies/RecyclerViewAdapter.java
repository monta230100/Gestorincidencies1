package com.example.gestorincidencies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import data.Incidencia;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    ArrayList<Incidencia> incidencies = new ArrayList<Incidencia>();
    private Context context;

    public RecyclerViewAdapter(Context con){
        context = con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(incidencies.get(position).getNom());
        holder.etiquetaPrioritat.setText(incidencies.get(position).getPrioritat());
    }

    @Override
    public int getItemCount() {
        return incidencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom, etiquetaPrioritat ;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.incidencia);
            etiquetaPrioritat = itemView.findViewById(R.id.Nivell);


            layout = itemView.findViewById(R.id.layout);
        }
    }
}