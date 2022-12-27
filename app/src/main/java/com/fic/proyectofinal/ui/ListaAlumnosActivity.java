package com.fic.proyectofinal.ui;

import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;

import android.widget.Toast;

import com.fic.proyectofinal.R;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.entidades.Alumno;
import com.fic.proyectofinal.domain.DominioAlumno;
import com.fic.proyectofinal.utils.Constantes;
import com.fic.proyectofinal.utils.Utileria;

import java.util.ArrayList;
import java.util.List;

public class ListaAlumnosActivity extends BaseActivity {

    ListView lvAlumnos;
    List<Alumno> listaAlumnos = new ArrayList<>();
    AdaptadorAlumnos adaptadorAlumnos;
    private int idCurso;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumnos);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Constantes.LISTA_ALUMNOS);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_fic)));
        }

        lvAlumnos = findViewById(R.id.lvAlumnos);
        Utileria util = new Utileria(getApplicationContext());

        idCurso = util.obtenerIdCurso();
        mostrarListaAlumnos(idCurso);

        lvAlumnos.setOnItemClickListener(accionSeleccionAlumno);
    }

    public void mostrarListaAlumnos(int idCurso) {
        DominioAlumno dominioAlumno = new DominioAlumno();
        dominioAlumno.obtenerListaAlumnos(idCurso, new RespuestaPersonalizada<Alumno>() {
            @Override
            public void respuestaSatisfactoria(List<Alumno> respuesta) {
                listaAlumnos = respuesta;
                adaptadorAlumnos = new AdaptadorAlumnos(getApplicationContext(), R.layout.fila_alumno, listaAlumnos);

                lvAlumnos.setAdapter(adaptadorAlumnos);
                adaptadorAlumnos.notifyDataSetChanged();
            }

            @Override
            public void respuestaFallida() {
                Toast.makeText(getApplicationContext(),"No es posible establecer comunicación con el servicio, intente más tarde.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public ListView.OnItemClickListener accionSeleccionAlumno = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Alumno alumno = (Alumno) lvAlumnos.getItemAtPosition(i);
            mostrarDetalleAlumno(alumno.getId(), alumno.getNombre());
        }
    };

    public void mostrarDetalleAlumno(int idAlumno, String nombreAlumno){
        Intent intencionDetalleAlumno = new Intent(getApplicationContext(),TableroAlumnoActivity.class);
        intencionDetalleAlumno.putExtra("idAlumno",idAlumno);
        intencionDetalleAlumno.putExtra("nombreAlumno",nombreAlumno);
        startActivity(intencionDetalleAlumno);
    }

    public void onResume() {
        mostrarListaAlumnos(idCurso);
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        if (!new Utileria(getApplicationContext()).esUsuarioConSesion()) {
            cerrarSesion();
        }
    }

}