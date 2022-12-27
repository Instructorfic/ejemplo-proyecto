package com.fic.proyectofinal.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fic.proyectofinal.R;
import com.fic.proyectofinal.data.entidades.Alumno;

import java.util.List;

public class AdaptadorAlumnos extends ArrayAdapter<Alumno>  {

    private Context contexto;
    private List<Alumno> listaAlumnos;

    public AdaptadorAlumnos(@NonNull Context context, int resource, @NonNull List<Alumno> alumnos) {
        super(context, resource, alumnos);
        this.contexto = context;
        this.listaAlumnos = alumnos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater infladorVista = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View fila = infladorVista.inflate(R.layout.fila_alumno,parent,false);

        TextView txtIdAlumno = fila.findViewById(R.id.txtCalificacionAlumno);
        TextView txtNombreAlumno = fila.findViewById(R.id.txtNombreAlumno);

        String nombre = listaAlumnos.get(position).getNombre();
        String calificacion = "Calificación: "+(int) listaAlumnos.get(position).getCalificacionCurso();
        txtIdAlumno.setText(calificacion);
        txtNombreAlumno.setText(nombre);

        return fila;
    }
}
