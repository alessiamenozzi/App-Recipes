package com.example.po_ricette.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.po_ricette.R;
import com.example.po_ricette.databinding.FragmentHomeBinding;
import com.example.po_ricette.models.Ricetta;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

// implemento la classe OnClickListener che contiene il metodo astratto OnClick per gestire gli eventi del pulsante

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    private ArrayList<Ricetta> ricette;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        view.findViewById(R.id.btn_antipasti).setOnClickListener(this);
        view.findViewById(R.id.btn_primi).setOnClickListener(this);
        view.findViewById(R.id.btn_secondi).setOnClickListener(this);
        view.findViewById(R.id.btn_dolci).setOnClickListener(this);
        this.getRicette(db.collection("Ricette"));
        return view;
    }

    private void getRicette(Query q){
        q.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.isEmpty()) {
                    Toast.makeText(getActivity(),"Nessun risulatato",Toast.LENGTH_SHORT).show();
                }
                else{
                    ricette = new ArrayList<Ricetta>();
                    List<DocumentSnapshot> Documents =queryDocumentSnapshots.getDocuments(); //lista di tutti i documenti
                    for(DocumentSnapshot d : Documents){
                        Ricetta ricetta=d.toObject(Ricetta.class);
                        ricette.add(ricetta);
                        System.out.println(ricetta.getNome());
                    }
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
    public void onClick(View view){
        String categoria="";
        switch (view.getId()){
            case R.id.btn_antipasti: categoria="antipasto"; break;
            case R.id.btn_primi: categoria="primo"; break;
            case R.id.btn_secondi: categoria="secondo"; break;
            case R.id.btn_dolci: categoria="dolce"; break;
        }
        CollectionReference data=db.collection("Ricette");
        Query query = data.whereEqualTo("categoria", categoria);
        getRicette(query);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}