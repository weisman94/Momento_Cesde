package com.example.sagf.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sagf.ListarActivoActivity;
import com.example.sagf.ListarServicioActivity;
import com.example.sagf.NuevoActivoActivity;
import com.example.sagf.NuevoServicioActivity;
import com.example.sagf.R;

public class MenuServicio extends AppCompatActivity {

    private Button btnAggservicio,btnListarServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_servicio);

        init();
        btnAggservicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent NSA = new Intent(MenuServicio.this, NuevoServicioActivity.class);
                startActivity(NSA);
            }
        });
        btnListarServicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent LSA = new Intent(MenuServicio.this, ListarServicioActivity.class);
                startActivity(LSA);
            }
        });
    }

    private void init(){
        btnAggservicio = findViewById(R.id.btnAggservicio);
        btnListarServicio = findViewById(R.id.btnListarServicio);
    }
}
