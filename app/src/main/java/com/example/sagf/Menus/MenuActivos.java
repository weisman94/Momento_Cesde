package com.example.sagf.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sagf.ListarActivoActivity;
import com.example.sagf.NuevoActivoActivity;
import com.example.sagf.NuevoUsuarioActivity;
import com.example.sagf.R;

public class MenuActivos extends AppCompatActivity {
    private Button btnAggAct,btnListarActivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activos);

        init();
        btnAggAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent Aga = new Intent(MenuActivos.this, NuevoActivoActivity.class);
                startActivity(Aga);
            }
        });
        btnListarActivo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent LA = new Intent(MenuActivos.this, ListarActivoActivity.class);
                startActivity(LA);
            }
        });
    }

    private void init(){
        btnAggAct = findViewById(R.id.btnAggActivo);
        btnListarActivo = findViewById(R.id.btnListarActivo);
    }
}
