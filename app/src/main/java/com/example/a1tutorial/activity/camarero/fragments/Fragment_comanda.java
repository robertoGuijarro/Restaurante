package com.example.a1tutorial.activity.camarero.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1tutorial.R;
import com.example.a1tutorial.adaptador.AdaptadorCartaComida;
import com.example.a1tutorial.adaptador.AdaptadorComandaComida;
import com.example.a1tutorial.models.Carta;
import com.example.a1tutorial.providers.CartaComidaDatabaseProvider;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class Fragment_comanda extends Fragment implements View.OnClickListener{

    View mView;
    CartaComidaDatabaseProvider cartaDatabase;
    RecyclerView listadoCartaComida;
    Button btnCarne, btnPescado, btnCocidos, btnEntrantes, btnPostre, btnAñadir;

    public Fragment_comanda(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_camarero_comanda, container, false);

        cartaDatabase = new CartaComidaDatabaseProvider();

        listadoCartaComida = mView.findViewById(R.id.listado_carta_comanda);
        listadoCartaComida.setLayoutManager(new LinearLayoutManager(getContext()));

        btnCarne = mView.findViewById(R.id.btn_comanda_carne);
        btnCarne.setOnClickListener(this);
        btnPescado = mView.findViewById(R.id.btn_comanda_pescados);
        btnPescado.setOnClickListener(this);
        btnCocidos = mView.findViewById(R.id.btn_comanda_cocidos);
        btnCocidos.setOnClickListener(this);
        btnEntrantes = mView.findViewById(R.id.btn_comanda_entrante);
        btnEntrantes.setOnClickListener(this);
        btnPostre = mView.findViewById(R.id.btn_comanda_postre);
        btnPostre.setOnClickListener(this);

        cargarCardView(cartaDatabase.getAll());
        return mView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnCarne.getId()){
            cargarCardView(cartaDatabase.getCarne());
        }
        if (v.getId() == btnCocidos.getId()){
            cargarCardView(cartaDatabase.getCocidos());
        }
        if (v.getId() == btnEntrantes.getId()){
            cargarCardView(cartaDatabase.getEntrantes());
        }
        if (v.getId() == btnPescado.getId()){
            cargarCardView(cartaDatabase.getPescado());
        }
        if (v.getId() == btnPostre.getId()) {
            cargarCardView(cartaDatabase.getPostre());
        }
    }

    private void cargarCardView(Query query) {
        FirestoreRecyclerOptions<Carta>options = new FirestoreRecyclerOptions.Builder<Carta>().setQuery(query, Carta.class).build();
        AdaptadorComandaComida adaptadorComandaComida = new AdaptadorComandaComida(options);

        listadoCartaComida.setAdapter(adaptadorComandaComida);
        adaptadorComandaComida.startListening();
    }
}
