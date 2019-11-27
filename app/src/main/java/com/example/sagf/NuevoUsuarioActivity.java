package com.example.sagf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class NuevoUsuarioActivity extends AppCompatActivity {

    private EditText etCedula, etDireccion, etTipoUsuario,etNombre, etclave, etUsuario;
    private Button btnRegistrar;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        init();

        btnRegistrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String dident = etCedula.getText().toString();
                String Direccion = etDireccion.getText().toString();
                String tuser = etTipoUsuario.getText().toString();
                String usuario = etUsuario.getText().toString();
                String nombre = etNombre.getText().toString();
                String clave = etclave.getText().toString();
                guardar(dident, Direccion, tuser, nombre,usuario, clave);
            }
        });

    }

    private void init(){
        etCedula = findViewById(R.id.etCedula);
        etDireccion = findViewById(R.id.etDireccion);
        etTipoUsuario = findViewById(R.id.etTipoUsuario);
        etNombre = findViewById(R.id.etNombre);
        etclave = findViewById(R.id.etclave);
        etUsuario = findViewById(R.id.etUsuario);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        db = FirebaseFirestore.getInstance();
    }
    private void guardar(String dident, String Direccion, String tuser, final String nombre, String usuario, String clave){
        Toast.makeText(NuevoUsuarioActivity.this, "Guardando Usuario", Toast.LENGTH_SHORT).show();
        String id = UUID.randomUUID().toString();
        Map<String,Object> user = new HashMap<>();
        user.put("id",id);
        user.put("NIT",dident);
        user.put("direccion",Direccion);
        user.put("user",usuario);
        user.put("tipousuario",tuser);
        user.put("nombre",nombre);
        user.put("clave",clave);

        db.collection("usuario")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(NuevoUsuarioActivity.this, "DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NuevoUsuarioActivity.this, "Error adding document. Error " + e, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(NuevoUsuarioActivity.this, "Usuario con "+ nombre + " creado", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(NuevoUsuarioActivity.this, "Tarea cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
        limpiarCampos();


        Toast.makeText(NuevoUsuarioActivity.this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
    }
    public void limpiarCampos(){
        etCedula.setText("");
        etDireccion.setText("");
        etTipoUsuario.setText("");
        etUsuario.setText("");
        etNombre.setText("");
        etclave.setText("");
        etCedula.requestFocus();
    }

}
