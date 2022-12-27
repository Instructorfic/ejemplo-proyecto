package com.fic.proyectofinal.data.api.servicios;

import com.fic.proyectofinal.data.entidades.Curso;
import com.fic.proyectofinal.data.entidades.Profesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IProfesor {

    @GET("profesores")
    Call<List<Profesor>> obtenerDatosProfesor(@Query("usuario") int numero, @Query("contrasena") String contrasena);
}
