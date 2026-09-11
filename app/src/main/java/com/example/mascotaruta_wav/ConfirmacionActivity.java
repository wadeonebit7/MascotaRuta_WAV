package com.example.mascotaruta_wav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacionActivity extends AppCompatActivity {

    TextView txtnombre;
    TextView txtgenero;
    TextView txtperfil;
    Button btnregreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnombre = findViewById(R.id.txtNombre);
        txtgenero = findViewById(R.id.txtGenero);
        txtperfil = findViewById(R.id.txtPerfil);

        btnregreso = findViewById(R.id.btnRegreso);

        Intent intentRecibido = getIntent();

        String name = intentRecibido.getStringExtra("NOMBRE");
        String genero = intentRecibido.getStringExtra("GENERO");
        String estado = intentRecibido.getStringExtra("ESTADO");

        txtnombre.setText("Nombre: " + name);
        txtgenero.setText("Genero: " + genero);
        txtperfil.setText("Perfil: " + estado);

        btnregreso.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmacionActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            startActivity(intent);
        });
    }
}