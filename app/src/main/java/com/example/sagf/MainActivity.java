package com.example.sagf;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sagf.Menus.MenuActivity;
import com.example.sagf.R;
import com.example.sagf.models.Usuarios;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario, etClave;
    private TextView btnincio;
    private FirebaseFirestore db;
    private SharedPreferences preferences;
    private Usuarios usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        btnincio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Loguin();
            }
        });
    }

    private void init(){
        btnincio = findViewById(R.id.btnincio);
        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);
        db = FirebaseFirestore.getInstance();
        preferences = this.getSharedPreferences(("session_sp"), Context.MODE_PRIVATE);
        usuario = new Usuarios();

    }

    private void Loguin(){
        String user = etUsuario.getText().toString();
        String clave = etClave.getText().toString();

        db.collection("usuario")
                .whereEqualTo("user",user)
                .whereEqualTo("clave",clave)
                .get()
                .addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {
                alert("Cancelado en el camino");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                alert("Fallo" + e.getMessage());
            }
        }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.getDocuments() != null) {
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        //alert(document.getId() + " => " + document.getData());
                        usuario = document.toObject(Usuarios.class);
                        guardarPrefeencias(usuario, document.getId());
                        //Log.d(TAG, document.getId() + " => " + document.getData());

                    }
                } else {
                    alert("Sin Datos");
                }
            limpiarCampos();
            }

        });
    }

    public void alert(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }

    private void guardarPrefeencias(Usuarios usuario, String usuarioid){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("inicio",true);
        editor.putString("nombre",usuario.getNombre());
        editor.putString("tipousuario",usuario.getTipousuario());
        editor.putString("id",usuarioid);
        editor.commit();

        irmenu();
    }

    protected void irmenu(){
        Intent M = new Intent(this, MenuActivity.class);
        startActivity(M);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void limpiarCampos() {
        etUsuario.setText("");
        etClave.setText("");
        etUsuario.requestFocus();
    }
}
