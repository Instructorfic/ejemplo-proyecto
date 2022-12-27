package com.fic.proyectofinal.domain;

import com.fic.proyectofinal.data.api.ConexionAPI;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.api.servicios.ICurso;
import com.fic.proyectofinal.data.entidades.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DominioCurso {

    public static ICurso iCurso;

    public static final String TAG_CURSOS = DominioCurso.class.getSimpleName();

    public DominioCurso() {
        iCurso = ConexionAPI.obtenerConexionAPI().create(ICurso.class);
    }

    public void obtenerIndicadoresGeneralesCurso(int idCurso, RespuestaPersonalizada respuestaPersonalizada) {
        Call<List<Curso>> obtenerIndicadoresCurso = iCurso.obtenerIndicadoresCurso(idCurso);

        obtenerIndicadoresCurso.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {

                if (response.isSuccessful()) {
                    respuestaPersonalizada.respuestaSatisfactoria(response.body());
                } else {
                    respuestaPersonalizada.respuestaFallida();
                }

            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                respuestaPersonalizada.respuestaFallida();
            }
        });

    }
}
