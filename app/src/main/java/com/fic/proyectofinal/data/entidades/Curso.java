package com.fic.proyectofinal.data.entidades;


import com.google.gson.annotations.SerializedName;


public class Curso
{
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("promedio_general")
    private String promedioGeneral;
    @SerializedName("alumnos_aprobados")
    private String alumnosAprobados;
    @SerializedName("alumnos_reprobados")
    private String alumnosReprobados;

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

    public String getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(String promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    public String getAlumnosAprobados() {
        return alumnosAprobados;
    }

    public void setAlumnosAprobados(String alumnosAprobados) {
        this.alumnosAprobados = alumnosAprobados;
    }

    public String getAlumnosReprobados() {
        return alumnosReprobados;
    }

    public void setAlumnosReprobados(String alumnosReprobados) {
        this.alumnosReprobados = alumnosReprobados;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", promedioGeneral='" + promedioGeneral + '\'' +
                ", alumnosAprobados='" + alumnosAprobados + '\'' +
                ", alumnosReprobados='" + alumnosReprobados + '\'' +
                '}';
    }
}
