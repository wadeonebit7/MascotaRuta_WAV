package com.example.mascotaruta_wav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarMascotaActivity extends AppCompatActivity {

    EditText nombre;
    RadioGroup genero;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar_mascota);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre = findViewById(R.id.etNombre);
        genero = findViewById(R.id.rgGenero);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(v -> {

            String nombrePerruno = nombre.getText().toString().trim();

            if (nombrePerruno.isEmpty()) {
                nombre.setError("Primero ingresa el nombre del producto");
                return;
            }

            int idGenero = genero.getCheckedRadioButtonId();
            RadioButton radioSelect = findViewById(idGenero);

            String generoSelect = radioSelect.getText().toString();

            Intent intent = new Intent( RegistrarMascotaActivity.this, ConfirmacionActivity.class);

            intent.putExtra("NOMBRE", nombrePerruno);
            intent.putExtra("GENERO", generoSelect);

            startActivity(intent);
    }


}