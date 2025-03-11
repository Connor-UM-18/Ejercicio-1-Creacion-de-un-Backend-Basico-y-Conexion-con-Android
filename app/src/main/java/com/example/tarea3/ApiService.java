package com.example.tarea3;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("hola")
    Call<Mensaje> obtenerMensaje();
}