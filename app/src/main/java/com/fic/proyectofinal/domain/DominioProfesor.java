package com.fic.proyectofinal.domain;

import com.fic.proyectofinal.data.api.ConexionAPI;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.api.servicios.ICurso;
import com.fic.proyectofinal.data.api.servicios.IProfesor;
import com.fic.proyectofinal.data.entidades.Curso;
import com.fic.proyectofinal.data.entidades.Profesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DominioProfesor {

    public static IProfesor iProfesor;

    public static final String TAG_PROFESORES = DominioCurso.class.getSimpleName();

    public DominioProfesor() {
        iProfesor = ConexionAPI.obtenerConexionAPI().create(IProfesor.class);
    }

    public void obtenerDatosProfesor(int numero, String identificacionAcceso, RespuestaPersonalizada respuestaPersonalizada) {
        Call<List<Profesor>> datosProfesor = iProfesor.obtenerDatosProfesor(numero,identificacionAcceso);

        datosProfesor.enqueue(new Callback<List<Profesor>>() {
            @Override
            public void onResponse(Call<List<Profesor>> call, Response<List<Profesor>> response) {

                if (response.isSuccessful()) {
                    respuestaPersonalizada.respuestaSatisfactoria(response.body());
                } else {
                    respuestaPersonalizada.respuestaFallida();
                }

            }

            @Override
            public void onFailure(Call<List<Profesor>> call, Throwable t) {
                respuestaPersonalizada.respuestaFallida();
            }
        });
    }
}
