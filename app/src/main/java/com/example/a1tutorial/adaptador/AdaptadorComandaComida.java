package com.example.a1tutorial.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1tutorial.R;
import com.example.a1tutorial.models.Carta;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class AdaptadorComandaComida extends FirestoreRecyclerAdapter<Carta, AdaptadorComandaComida.ViewComandaComida> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdaptadorComandaComida(@NonNull FirestoreRecyclerOptions<Carta> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdaptadorComandaComida.ViewComandaComida holder, int position, @NonNull Carta model) {
        holder.txtNombre.setText(model.getNombre());
        holder.txtPrecio.setText(model.getPrecio()+"");
    }

    @NonNull
    @Override
    public AdaptadorComandaComida.ViewComandaComida onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comanda_comida, parent, false);
        return new ViewComandaComida(vista);
    }

    public class ViewComandaComida extends RecyclerView.ViewHolder {

        TextView txtNombre, txtPrecio, txtCantidad;
        Button btnMas, btnMenos;
        public ViewComandaComida(View vista) {
            super(vista);
            txtPrecio = vista.findViewById(R.id.txt_item_comanda_precio);
            txtCantidad = vista.findViewById(R.id.txt_item_comanda_cantidad);
            txtNombre = vista.findViewById(R.id.txt_item_comanda_nombre);

            btnMas = vista.findViewById(R.id.btn_item_comanda_mas);
            btnMas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int cantidad = Integer.parseInt(txtCantidad.getText().toString());
                    cantidad++;
                    txtCantidad.setText(cantidad+"");
                }
            });
            btnMenos = vista.findViewById(R.id.btn_item_comanda_menos);
            btnMenos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int cantidad = Integer.parseInt(txtCantidad.getText().toString());
                    if (cantidad>0){
                        cantidad--;
                        txtCantidad.setText(cantidad+"");
                    }
                }
            });
        }
    }
}
