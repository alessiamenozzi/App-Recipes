package com.example.po_ricette.ui.aggiungi;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.po_ricette.R;
import com.example.po_ricette.databinding.FragmentAggiungiBinding;
import com.example.po_ricette.models.Ingrediente;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AggiungiFragment extends Fragment {

    private FragmentAggiungiBinding binding;
    private ArrayList<Ingrediente> ingredienti;
    private ArrayList<String> nomi_ingredienti;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private RecyclerView recyclerView_ingredienti;
    private RecyclerView recyclerView_strumenti;
    private RecyclerViewAdapter gestoreListaIngredienti;
    private RecyclerViewAdapter gestoreListaStrumenti;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAggiungiBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView_ingredienti=view.findViewById(R.id.ingredienti);
        recyclerView_strumenti=view.findViewById(R.id.strumenti);
        recyclerView_ingredienti.setHasFixedSize(true);
        recyclerView_strumenti.setHasFixedSize(true);
        recyclerView_ingredienti.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_strumenti.setLayoutManager(new LinearLayoutManager(getActivity()));

        this.getIngredienti(db.collection("Ingredienti"));
        gestoreListaIngredienti=new RecyclerViewAdapter(nomi_ingredienti, getActivity());
        Resources res=getResources();
        String[] strumenti=res.getStringArray(R.array.strumenti);
        gestoreListaStrumenti=new RecyclerViewAdapter(Arrays.asList(strumenti), getActivity());
        recyclerView_ingredienti.setAdapter(gestoreListaIngredienti);
        recyclerView_strumenti.setAdapter(gestoreListaStrumenti);
        return view;
    }



    private void getIngredienti(Query q){
        q.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.isEmpty()) {
                    Toast.makeText(getActivity(),"Nessun risulatato",Toast.LENGTH_SHORT).show();
                }
                else{

                    ingredienti = new ArrayList<Ingrediente>();
                    nomi_ingredienti=new ArrayList<String>();
                    List<DocumentSnapshot> Documents =queryDocumentSnapshots.getDocuments(); //lista di tutti i documenti
                    for(DocumentSnapshot d : Documents){
                        Ingrediente ingrediente=d.toObject(Ingrediente.class);
                        ingredienti.add(ingrediente);
                        System.out.println(ingrediente.getNome());
                        nomi_ingredienti.add(ingrediente.getNome());
                    }
                   gestoreListaIngredienti.aggiornaLista(nomi_ingredienti);
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"Errore durante la connessione", Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}