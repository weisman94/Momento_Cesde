package com.example.sagf;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends MainActivity {

    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 2000; // 2 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tenemos una plantilla llamada splash_activity.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            ;
        }, DURACION_SPLASH);
    }
}
