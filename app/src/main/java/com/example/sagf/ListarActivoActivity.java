package com.example.sagf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sagf.adapters.ActivoAdapter;
import com.example.sagf.models.ActivoModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListarActivoActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private ListView lvllistas;
    private ActivoAdapter Cadaptar;
    private ActivoModel modelo;
    private ArrayList<ActivoModel> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_activo);
        inicializar();
        listarActivos();

        lvllistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                modelo = (ActivoModel) adapterView.getItemAtPosition(i);
                clickItem(modelo);
            }
        });

    }

    private void inicializar(){
        db = FirebaseFirestore.getInstance();
        lvllistas = findViewById(R.id.lvllistas);
        modelo = new ActivoModel();
        lista = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        Cadaptar = new ActivoAdapter(lista, this);
    }

    private void listarActivos(){
        db.collection("activos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        lista = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ActivoModel misses = document.toObject(ActivoModel.class);
                                lista.add(misses);
                            }
                            ListView lvListar = findViewById(R.id.lvllistas);
                            Cadaptar = new ActivoAdapter(lista, ListarActivoActivity.this);
                            lvListar.setAdapter(Cadaptar);
                        } else {
                            Log.d("MissionActivity", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }

    public void alert(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }
    private void clickItem(ActivoModel modelo) {
        Toast.makeText(this, "Usted presionó a " + modelo.getEtSerial(), Toast.LENGTH_LONG).show();
        String id = modelo.getId();
        irDetalle(id);
    }
    private void irDetalle(String id){
        Intent detalle = new Intent(this, NuevoUsuarioActivity.class);
        detalle.putExtra("id", id);
        startActivity(detalle);
    }

}
