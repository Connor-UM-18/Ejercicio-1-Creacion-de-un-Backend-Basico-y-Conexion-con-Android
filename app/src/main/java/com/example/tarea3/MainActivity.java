package com.example.tarea3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView txtMensaje;
    private Button btnCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asociar los elementos del layout con el código
        txtMensaje = findViewById(R.id.txtMensaje);
        btnCargar = findViewById(R.id.btnCargar);

        // Agregar evento al botón
        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerMensaje();
            }
        });
    }

    private void obtenerMensaje() {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        apiService.obtenerMensaje().enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                if (response.isSuccessful() && response.body() != null) {
                    txtMensaje.setText(response.body().getMensaje());
                } else {
                    txtMensaje.setText("Respuesta vacía");
                }
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {
                txtMensaje.setText("Error al obtener datos");
            }
        });
    }
}