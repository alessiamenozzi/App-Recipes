package com.example.po_ricette.ui.aggiungi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.po_ricette.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//gestore delle liste dinamiche (per ingredienti e strumenti)
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<String> dati;
    private Context context;

    public RecyclerViewAdapter(List<String> dati, Context context) {
        if(dati ==null)
        {
            dati=new ArrayList<String>();
        }

        else {
        this.dati = dati;}
        this.context = context;
    }

    public void clear(){
        if(dati !=null) {
            dati.clear();
        }

    }
    public void aggiornaLista(List<String> dati){
       this.clear();
       if(this.dati!=null)
           this.dati.addAll(dati);

       this.notifyDataSetChanged();

    }


    @NonNull
    @Override //creazione
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.checkbox_aggiungi,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        String value=dati.get(position);
        holder.checkBox.setText(value);
    }

    @Override
    public int getItemCount() {
       if(dati !=null) {
           return dati.size();
       }
       return 0;
    }

    //gestore singolo elemento della lista
    public class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.aggiungi_checkbox);
        }
    }
}
