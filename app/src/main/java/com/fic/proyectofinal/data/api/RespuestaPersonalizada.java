package com.fic.proyectofinal.data.api;

import com.fic.proyectofinal.data.entidades.Alumno;
import com.fic.proyectofinal.data.entidades.Curso;

import java.util.List;

public interface RespuestaPersonalizada<T> {

    void respuestaSatisfactoria(List<T> respuesta);

    void respuestaFallida();
}
