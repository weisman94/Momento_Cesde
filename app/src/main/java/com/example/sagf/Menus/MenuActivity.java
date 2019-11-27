package com.example.sagf.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sagf.MainActivity;
import com.example.sagf.R;

public class MenuActivity extends AppCompatActivity {

    Button btnUsuario, btnActivo, btnServicio, btnFacturar;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

      init();
      verificarSesion();

      String nombre = preferences.getString("nombre",null);
      alert("Bienvenido " + nombre);

        btnUsuario.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent c = new Intent(MenuActivity.this, MenuUsuarioAActivity.class);
                startActivity(c);
            }
        });

        btnActivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent A = new Intent(MenuActivity.this,MenuActivos.class);
                startActivity(A);
            }
        });
        btnServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent S = new Intent(MenuActivity.this,MenuServicio.class);
                startActivity(S);
            }
        });

        btnFacturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent F = new Intent(MenuActivity.this,MenuFactura.class);
                startActivity(F);
            }
        });

        }

        private void verificarSesion(){
        Boolean inicio = preferences.getBoolean("inicio",false);
        if (!inicio){
            irLogin();
        }
    }

    private void init(){
        btnUsuario = findViewById(R.id.btnUsuario);
        btnActivo = findViewById(R.id.btnActivos);
        btnServicio = findViewById(R.id.btnServicio);
        btnFacturar = findViewById(R.id.btnFactura);
        preferences = this.getSharedPreferences(("session_sp"), Context.MODE_PRIVATE);
    }

    private void irLogin(){
        Intent L = new Intent(this, MainActivity.class);
        startActivity(L);
    }


    public void alert(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }
}
