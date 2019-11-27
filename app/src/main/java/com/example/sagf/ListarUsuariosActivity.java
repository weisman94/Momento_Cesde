package com.example.sagf;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sagf.adapters.UsuarioAdapter;
import com.example.sagf.models.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListarUsuariosActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private ListView lvllista;
    private UsuarioAdapter Cadapter;
    private Usuarios model;
    private ArrayList<Usuarios> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);
        inicializar();
        listarClientes();

        lvllista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model = (Usuarios) adapterView.getItemAtPosition(i);
                clickItem(model);
            }
        });

    }

    private void inicializar(){
        db = FirebaseFirestore.getInstance();
        lvllista = findViewById(R.id.lvllista);
        model = new Usuarios();
        lista = new ArrayList<>();
        Cadapter = new UsuarioAdapter(lista, this);
    }

    private void listarClientes(){
        db.collection("usuario")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        lista = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Usuarios miss = document.toObject(Usuarios.class);
                                lista.add(miss);
                            }
                            ListView lvListar = findViewById(R.id.lvllista);
                            Cadapter = new UsuarioAdapter(lista, ListarUsuariosActivity.this);
                            lvListar.setAdapter(Cadapter);
                        } else {
                            Log.d("MissionActivity", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
    private void clickItem(Usuarios model) {
        Toast.makeText(this, "Usted presionó a " + model.getNombre(), Toast.LENGTH_LONG).show();
        String id = model.getId();
        irDetalle(id);
    }
    private void irDetalle(String id){
        Intent detalle = new Intent(this, NuevoUsuarioActivity.class);
        detalle.putExtra("id", id);
        startActivity(detalle);
    }

}
