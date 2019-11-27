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
import com.example.sagf.adapters.FacturaAdapter;
import com.example.sagf.adapters.ServicioAdapter;
import com.example.sagf.adapters.UsuarioAdapter;
import com.example.sagf.models.ActivoModel;
import com.example.sagf.models.FacturaModel;
import com.example.sagf.models.ServicioModel;
import com.example.sagf.models.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListarServicioActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private ListView lvllista;
    private ServicioAdapter Cadapter;
    private ServicioModel model;
    private ArrayList<ServicioModel> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_activo);
        inicializar();
        listarServicios();

        lvllista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model = (ServicioModel) adapterView.getItemAtPosition(i);
                clickItem(model);
            }
        });

    }

    private void inicializar(){
        db = FirebaseFirestore.getInstance();
        lvllista = findViewById(R.id.lvllista);
        model = new ServicioModel();
        lista = new ArrayList<>();
        Cadapter = new ServicioAdapter(lista, this);
    }

    private void listarServicios(){
        db.collection("Servicio")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        lista = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ServicioModel miss = document.toObject(ServicioModel.class);
                                lista.add(miss);
                            }
                            ListView lvListar = findViewById(R.id.lvllista);
                            Cadapter = new ServicioAdapter(lista, ListarServicioActivity.this);
                            lvListar.setAdapter(Cadapter);
                        } else {
                            Log.d("MissionActivity", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
    private void clickItem(ServicioModel model) {
        Toast.makeText(this, "Usted presionó a " + model.getEtAservicio(), Toast.LENGTH_LONG).show();
        String id = model.getId();
        irDetalle(id);
    }
    private void irDetalle(String id){
        Intent detalle = new Intent(this, NuevoServicioActivity.class);
        detalle.putExtra("id", id);
        startActivity(detalle);
    }

}
