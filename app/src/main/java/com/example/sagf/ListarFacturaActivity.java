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

import com.example.sagf.adapters.FacturaAdapter;
import com.example.sagf.models.FacturaModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListarFacturaActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private ListView lvFlista;
    private FacturaModel Fmodel;
    private FacturaAdapter Fadapter;
    private ArrayList<FacturaModel> lis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_factura);
        initi();
        listarFactura();

        lvFlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Fmodel = (FacturaModel) adapterView.getItemAtPosition(i);
                clickItem(Fmodel);
            }
        });
    }

    public void initi(){
        db = FirebaseFirestore.getInstance();
        lvFlista = findViewById(R.id.lvllistaFactura);
        Fmodel = new FacturaModel();
        lis = new ArrayList<>();
        Fadapter = new FacturaAdapter(lis,this);
    }

    private void clickItem(FacturaModel model) {
        Toast.makeText(this, "Usted presionó a " + Fmodel.getEtIdFactura(), Toast.LENGTH_LONG).show();
        String id = model.getId();
        irDetallito(id);
    }

    private void irDetallito(String id) {
        Intent detalle = new Intent(this, NuevaFacturaActivity.class);
        detalle.putExtra("id", id);
        startActivity(detalle);
    }

    private void listarFactura(){
        db.collection("factura")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        lis = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                FacturaModel nuevo = document.toObject(FacturaModel.class);
                                lis.add(nuevo);
                            }
                            ListView lvFlista = findViewById(R.id.lvllistaFactura);
                            Fadapter = new FacturaAdapter(lis, ListarFacturaActivity.this);
                            lvFlista.setAdapter(Fadapter);
                        } else {
                            Log.d("MissionActivity", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }
}
