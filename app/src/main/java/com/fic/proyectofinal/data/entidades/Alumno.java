package com.fic.proyectofinal.data.entidades;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Alumno implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("apellido_paterno")
    private String apellidoPaterno;
    @SerializedName("apellido_materno")
    private String apellidoMaterno;
    @SerializedName("curso")
    private String nombreCurso;
    @SerializedName("calificacion")
    private double calificacionCurso;
    @SerializedName("promedio_general")
    private double promedioGeneral;
    @SerializedName("materias_aprobadas")
    private int materiasAprobadas;
    @SerializedName("materias_reprobadas")
    private int materiasReprobadas;

    public Alumno(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String nombreCurso, double calificacionCurso) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreCurso = nombreCurso;
        this.calificacionCurso = calificacionCurso;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public double getCalificacionCurso() {
        return calificacionCurso;
    }

    public void setCalificacionCurso(double calificacionCurso) {
        this.calificacionCurso = calificacionCurso;
    }

    public double getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    public int getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(int materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public int getMateriasReprobadas() {
        return materiasReprobadas;
    }

    public void setMateriasReprobadas(int materiasReprobadas) {
        this.materiasReprobadas = materiasReprobadas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", calificacionCurso=" + calificacionCurso +
                ", promedioGeneral='" + promedioGeneral + '\'' +
                ", materiasAprobadas='" + materiasAprobadas + '\'' +
                ", materiasReprobadas='" + materiasReprobadas + '\'' +
                '}';
    }
}
