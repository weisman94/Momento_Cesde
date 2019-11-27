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

public class NuevaFacturaActivity extends AppCompatActivity {

    private EditText etIdFactura, etCliente, etServicio, etValor;
    private Button btnFacturar;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_factura);

        init();

        btnFacturar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String factura = etIdFactura.getText().toString();
                String cliente = etCliente.getText().toString();
                String servicio = etServicio.getText().toString();
                String descripcion = etValor.getText().toString();
                guardar(factura, cliente, servicio, descripcion);
            }
        });
    }

    public void init() {
        db = FirebaseFirestore.getInstance();
        etIdFactura = findViewById(R.id.etIdFactura);
        etCliente = findViewById(R.id.etCliente);
        etServicio = findViewById(R.id.etServicio);
        etValor = findViewById(R.id.etValor);
        btnFacturar = findViewById(R.id.btnFacturar);

    }

    private void guardar(final String factura, String cliente, String servicio, String descripcion) {
        Toast.makeText(NuevaFacturaActivity.this, "Guardando Factura", Toast.LENGTH_SHORT).show();
        String id = UUID.randomUUID().toString();
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("Factura", factura);
        user.put("Cliente", cliente);
        user.put("Servicio", servicio);
        user.put("Descripcion", descripcion);

        db.collection("factura")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(NuevaFacturaActivity.this, "DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NuevaFacturaActivity.this, "Error adding document. Error " + e, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(NuevaFacturaActivity.this, "Factura con id "+ factura + " creada", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(NuevaFacturaActivity.this, "Tarea cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
        limpiarCampos();


        Toast.makeText(NuevaFacturaActivity.this, "Factura Creada", Toast.LENGTH_SHORT).show();
    }
    public void limpiarCampos(){
        etIdFactura.setText("");
        etCliente.setText("");
        etServicio.setText("");
        etValor.setText("");
    }


}
