package com.fic.proyectofinal.data.entidades;

import com.google.gson.annotations.SerializedName;

public class Profesor {

    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("curso_id")
    private int idCurso;
    @SerializedName("descripcion")
    private String curso;

    public Profesor(int id, String nombre, int idCurso, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.idCurso = idCurso;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
