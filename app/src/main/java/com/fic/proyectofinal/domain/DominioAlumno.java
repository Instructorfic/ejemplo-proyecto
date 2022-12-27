package com.fic.proyectofinal.domain;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.fic.proyectofinal.data.api.ConexionAPI;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.api.servicios.IAlumnos;
import com.fic.proyectofinal.data.entidades.Alumno;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DominioAlumno {

    public static IAlumnos iAlumnos;

    public static final String TAG_ALUMNOS = IAlumnos.class.getSimpleName();

    public DominioAlumno() {
        iAlumnos = ConexionAPI.obtenerConexionAPI().create(IAlumnos.class);
    }


    public void obtenerCalificacionesAlumno(int idAlumno, RespuestaPersonalizada respuestaPersonalizada) {

        Call<List<Alumno>> obtenerCalificacionesAlumno = iAlumnos.obtenerCalificacionesAlumno(idAlumno);
        obtenerCalificacionesAlumno.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if (response.isSuccessful()) {
                    respuestaPersonalizada.respuestaSatisfactoria(response.body());
                } else {
                    respuestaPersonalizada.respuestaFallida();
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Log.d(TAG_ALUMNOS, t.toString());
                respuestaPersonalizada.respuestaFallida();
            }
        });

    }

    public void obtenerListaAlumnos(int idCurso, RespuestaPersonalizada respuestaPersonalizada) {
        Call<List<Alumno>> obtenerListaAlumnos = iAlumnos.obtenerCalificacionesAlumnosCurso(idCurso);
        obtenerListaAlumnos.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if (response.isSuccessful()) {
                    respuestaPersonalizada.respuestaSatisfactoria(response.body());
                } else {
                    respuestaPersonalizada.respuestaFallida();
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                respuestaPersonalizada.respuestaFallida();
            }
        });
    }

    public void obtenerIndicadoresAlumno(int idAlumno, RespuestaPersonalizada respuestaPersonalizada) {
        Call<List<Alumno>> obtenerIndicadoresAlumno = iAlumnos.obtenerIndicadoresAlumno(idAlumno);
        obtenerIndicadoresAlumno.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if (response.isSuccessful()) {
                    respuestaPersonalizada.respuestaSatisfactoria(response.body());
                } else {
                    respuestaPersonalizada.respuestaFallida();
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                respuestaPersonalizada.respuestaFallida();
            }
        });
    }

    public void asignarCalificacionAlumno(int idAlumno, int idCurso, int calificacion, RespuestaPersonalizada respuestaPersonalizada) {
        Call<List<Alumno>> asignarCalificacionAlumno = iAlumnos.asignarCalificacionCursoAlumno(idAlumno,idCurso,calificacion);
        asignarCalificacionAlumno.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if (response.isSuccessful()) {
                    respuestaPersonalizada.respuestaSatisfactoria(response.body());
                } else {
                    respuestaPersonalizada.respuestaFallida();
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                respuestaPersonalizada.respuestaFallida();
            }
        });
    }

}
