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

public class NuevoActivoActivity extends AppCompatActivity {
    private EditText etSerial, etTelemento, etModelo, etMarca, etempresa, etDescripcion;
    private Button btnRegistroActivo;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_activo);

        init();

        btnRegistroActivo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String serial = etSerial.getText().toString();
                String elemento = etTelemento.getText().toString();
                String modelo = etModelo.getText().toString();
                String marca = etMarca.getText().toString();
                String empresa = etempresa.getText().toString();
                String descripcion = etDescripcion.getText().toString();
                guardar(serial, elemento, modelo, marca,empresa, descripcion);
            }
        });
    }

    private void init() {
        etSerial = findViewById(R.id.etSerial);
        etTelemento = findViewById(R.id.etTelemento);
        etModelo = findViewById(R.id.etModelo);
        etMarca = findViewById(R.id.etMarca);
        etempresa = findViewById(R.id.etempresa);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnRegistroActivo = findViewById(R.id.btnRegistroActivo);
        db = FirebaseFirestore.getInstance();
    }

    private void guardar(final String serial, String elemento, String modelo, String marca, String empresa, String descripcion){
        Toast.makeText(NuevoActivoActivity.this, "Guardando Activo", Toast.LENGTH_SHORT).show();
        String id = UUID.randomUUID().toString();
        Map<String,Object> user = new HashMap<>();
        user.put("id",id);
        user.put("NIT",serial);
        user.put("direccion",elemento);
        user.put("user",empresa);
        user.put("tipousuario",modelo);
        user.put("nombre",marca);
        user.put("clave",descripcion);

        db.collection("activos")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(NuevoActivoActivity.this, "DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NuevoActivoActivity.this, "Error adding document. Error " + e, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(NuevoActivoActivity.this, "Activo con " + serial + " Creado", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(NuevoActivoActivity.this, "Tarea cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
        limpiarCampos();


        Toast.makeText(NuevoActivoActivity.this, "Activo Guardado", Toast.LENGTH_SHORT).show();
    }
    public void limpiarCampos(){
        etSerial.setText("");
        etTelemento.setText("");
        etMarca.setText("");
        etModelo.setText("");
        etempresa.setText("");
        etDescripcion.setText("");
        etSerial.requestFocus();
    }
}
