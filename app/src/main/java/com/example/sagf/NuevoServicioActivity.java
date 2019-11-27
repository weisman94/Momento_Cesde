package com.example.sagf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NuevoServicioActivity extends AppCompatActivity {

    private EditText  etAservicio, etIdUser,etArea, etTservicio, etElemento,etDescrip;
    private Button btnCrearSer;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_servicio);

        init();

        btnCrearSer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String Asunto = etAservicio.getText().toString();
                String Cliente = etIdUser.getText().toString();
                String Area = etArea.getText().toString();
                String Servicio = etTservicio.getText().toString();
                String Elemento = etElemento.getText().toString();
                String Descripcion = etDescrip.getText().toString();
                guardar(Asunto, Cliente, Area, Servicio,Elemento, Descripcion);
            }
        });
    }

    private void guardar(String Asunto, String Cliente, String Area, final String Servicio, String Elemento, String Descripcion){
        Toast.makeText(NuevoServicioActivity.this, "Servicio Creado", Toast.LENGTH_SHORT).show();
        final String id = UUID.randomUUID().toString();
        Map<String,Object> user = new HashMap<>();
        user.put("id",id);
        user.put("Asunto",Asunto);
        user.put("Cliente ID",Cliente);
        user.put("Elemento",Elemento);
        user.put("Area",Area);
        user.put("Servicio",Servicio);
        user.put("Descripcion",Descripcion);

        db.collection("Servicio")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(NuevoServicioActivity.this, "DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NuevoServicioActivity.this, "Error adding document. Error " + e, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(NuevoServicioActivity.this, "Usuario con "+ id + " creado", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(NuevoServicioActivity.this, "Tarea cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
        limpiarCampos();


        Toast.makeText(NuevoServicioActivity.this, "Servicio Creado", Toast.LENGTH_SHORT).show();
    }
    public void limpiarCampos(){
        etAservicio.setText("");
        etIdUser.setText("");
        etArea.setText("");
        etTservicio.setText("");
        etElemento.setText("");
        etDescrip.setText("");
        etAservicio.requestFocus();
    }

    private void init() {
        etAservicio = findViewById(R.id.etAservicio);
        etIdUser = findViewById(R.id.etIdUser);
        etArea = findViewById(R.id.etArea);
        etTservicio = findViewById(R.id.etTservicio);
        etElemento = findViewById(R.id.etElemento);
        etDescrip = findViewById(R.id.etDescrip);
        btnCrearSer = findViewById(R.id.btnCrearSer);
        db = FirebaseFirestore.getInstance();
    }
}
