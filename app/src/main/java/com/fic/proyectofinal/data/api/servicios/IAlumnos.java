package com.fic.proyectofinal.data.api.servicios;

import com.fic.proyectofinal.data.entidades.Alumno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IAlumnos {

    @GET("alumnos/calificaciones")
    Call<List<Alumno>> obtenerCalificacionesAlumnos();

    @GET("alumnos/{idAlumno}/calificaciones")
    Call<List<Alumno>> obtenerCalificacionesAlumno(@Path("idAlumno") int id);

    @GET("alumnos/curso/{idCurso}/calificaciones")
    Call<List<Alumno>> obtenerCalificacionesAlumnosCurso(@Path("idCurso") int id);

    @GET("alumnos/{idAlumno}/indicadores")
    Call<List<Alumno>> obtenerIndicadoresAlumno(@Path("idAlumno") int id);

    @PUT("alumnos/{idAlumno}/curso/{idCurso}/calificacion/{calificacion}")
    Call<List<Alumno>> asignarCalificacionCursoAlumno(@Path("idAlumno") int idAlumno,@Path("idCurso") int idCurso,@Path("calificacion") int calificacion);
}
