package com.example.sagf.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sagf.ListarActivoActivity;
import com.example.sagf.ListarFacturaActivity;
import com.example.sagf.NuevaFacturaActivity;
import com.example.sagf.NuevoActivoActivity;
import com.example.sagf.R;

public class MenuFactura extends AppCompatActivity {

    private Button btnAggFact,btnListarFactura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_factura);
        init();
        btnAggFact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent NFA = new Intent(MenuFactura.this, NuevaFacturaActivity.class);
                startActivity(NFA);
            }
        });
        btnListarFactura.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent LFA = new Intent(MenuFactura.this, ListarFacturaActivity.class);
                startActivity(LFA);
            }
        });
    }

    private void init(){
        btnAggFact = findViewById(R.id.btnAggFactura);
        btnListarFactura = findViewById(R.id.btnListarFactura);
    }
}
