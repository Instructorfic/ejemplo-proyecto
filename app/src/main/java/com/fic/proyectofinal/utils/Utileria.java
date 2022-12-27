package com.fic.proyectofinal.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.fic.proyectofinal.ui.InicioSesionActivity;

public class Utileria {

    Context contexto;

    public Utileria(Context contexto) {
        this.contexto = contexto;
    }


    public SharedPreferences obtenerPreferenciasUsuario() {
        return this.contexto.getSharedPreferences(Constantes.PREFERENCIAS_USUARIO, contexto.MODE_PRIVATE);
    }

    public int obtenerIdCurso() {
        return obtenerPreferenciasUsuario().getInt(Constantes.CLAVE_ID_CURSO, 0);
    }

    public String obtenerNombreProfesor(){
        return obtenerPreferenciasUsuario().getString(Constantes.CLAVE_NOMBRE_PROFESOR,"");
    }

    public String obtenerNombreCurso(){
        return obtenerPreferenciasUsuario().getString(Constantes.CLAVE_NOMBRE_CURSO,"");
    }

    public boolean esUsuarioConSesion() {
        return obtenerPreferenciasUsuario().getInt(Constantes.CLAVE_SESION_ACTIVA, 0) == 1;
    }
}
