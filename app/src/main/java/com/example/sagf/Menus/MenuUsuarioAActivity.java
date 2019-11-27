package com.example.sagf.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sagf.ListarUsuariosActivity;
import com.example.sagf.NuevoUsuarioActivity;
import com.example.sagf.R;

public class MenuUsuarioAActivity extends AppCompatActivity {
    private Button btnAggUser,btnListarUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario_a);

        init();
        btnAggUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent AG = new Intent(MenuUsuarioAActivity.this, NuevoUsuarioActivity.class);
                startActivity(AG);
            }
        });
        btnListarUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent LU = new Intent(MenuUsuarioAActivity.this, ListarUsuariosActivity.class);
                startActivity(LU);
            }
        });

    }

    private void init(){
        btnAggUser = findViewById(R.id.btnAggUser);
        btnListarUser = findViewById(R.id.btnListarUser);
    }
}
