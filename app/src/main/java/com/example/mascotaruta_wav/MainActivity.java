package com.example.mascotaruta_wav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnTutor;
    Button btnRescatista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnTutor = findViewById(R.id.btnTutor);
        btn.setOnClickListener(v -> {
            String estado = "Rescatista";
            Intent intent = new Intent(MainActivity.this, RegistrarMascotaActivity.class);

            intent.putExtra("ESTADO", estado);

            startActivity(intent);
        });

        btnRescatista = findViewById(R.id.btnRescatista);
        btn.setOnClickListener(v -> {
            String estado = "Rescatista";
            Intent intent = new Intent(MainActivity.this, RegistrarMascotaActivity.class);

            intent.putExtra("ESTADO", estado);

            startActivity(intent);
        });
    }
}