package com.fic.proyectofinal.data.api.servicios;

import com.fic.proyectofinal.data.entidades.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICurso {


    @GET("alumnos/curso/{idCurso}/indicadores")
    Call<List<Curso>> obtenerIndicadoresCurso(@Path("idCurso") int id);
}
