package com.fic.proyectofinal.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fic.proyectofinal.R;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.entidades.Alumno;
import com.fic.proyectofinal.domain.DominioAlumno;
import com.fic.proyectofinal.utils.Constantes;
import com.fic.proyectofinal.utils.Utileria;

import java.util.List;

public class TableroAlumnoActivity extends BaseActivity {

    TextView txtPromedioGeneralAlumno, txtNumeroMateriasAprobadas, txtNumeroMateriasReprobadas, txtCalificacionCurso;
    Button btnCalificacionAlumno;

    private int idAlumno;
    private int idCurso;
    private String nombreAlumno;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero_alumno);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Constantes.TABLERO_ALUMNO + getIntent().getStringExtra("nombreAlumno"));
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_fic)));
        }

        txtPromedioGeneralAlumno = findViewById(R.id.txtPromedioGeneralAlumno);
        txtNumeroMateriasAprobadas = findViewById(R.id.txtNumeroMateriasAprobadas);
        txtNumeroMateriasReprobadas = findViewById(R.id.txtNumeroMateriasReprobadas);
        btnCalificacionAlumno = findViewById(R.id.btnCalificacionCurso);

        btnCalificacionAlumno.setOnClickListener(accionBotonCalificacion);
        idAlumno = getIntent().getIntExtra("idAlumno", 0);
        Utileria util = new Utileria(getApplicationContext());

        idCurso = util.obtenerIdCurso();
        mostrarIndicadoresGeneralesAlumno(idAlumno);


    }

    public View.OnClickListener accionBotonCalificacion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mostrarCuadroDialogoCalificacion();
        }
    };

    public void mostrarIndicadoresGeneralesAlumno(int idAlumno) {
        DominioAlumno dominioAlumno = new DominioAlumno();
        dominioAlumno.obtenerIndicadoresAlumno(idAlumno, new RespuestaPersonalizada<Alumno>() {
            @Override
            public void respuestaSatisfactoria(List<Alumno> respuesta) {
                txtPromedioGeneralAlumno.setText(String.valueOf(respuesta.get(0).getPromedioGeneral()));
                txtNumeroMateriasAprobadas.setText(String.valueOf(respuesta.get(0).getMateriasAprobadas()));
                txtNumeroMateriasReprobadas.setText(String.valueOf(respuesta.get(0).getMateriasReprobadas()));
            }

            @Override
            public void respuestaFallida() {
                Toast.makeText(getApplicationContext(), "No es posible establecer comunicación con el servicio, intente más tarde.", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void mostrarCuadroDialogoCalificacion() {
        crearCuadroDialogoCalificacion().show();
    }

    public AlertDialog crearCuadroDialogoCalificacion() {
        String[] listaCalificaciones = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int[] elementoSeleccionado = {-1};
        AlertDialog.Builder cuadroDialogo = new AlertDialog.Builder(TableroAlumnoActivity.this);
        cuadroDialogo.setTitle("Seleccione la calificación");
        cuadroDialogo.setSingleChoiceItems(listaCalificaciones, elementoSeleccionado[0], asignarCalificacionCurso);

        return cuadroDialogo.create();
    }

    public DialogInterface.OnClickListener asignarCalificacionCurso = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            asiganarCalificacionCursoAlumno(idAlumno, idCurso, i);
            dialogInterface.dismiss();
        }
    };

    public void asiganarCalificacionCursoAlumno(int idAlumno, int idCurso, int calificacion) {
        DominioAlumno dominioAlumno = new DominioAlumno();
        dominioAlumno.asignarCalificacionAlumno(idAlumno, idCurso, calificacion, new RespuestaPersonalizada<Alumno>() {
            @Override
            public void respuestaSatisfactoria(List<Alumno> respuesta) {
                //mostrarIndicadoresGeneralesAlumno(idAlumno);
                mostrarListaAlumnos();
            }

            @Override
            public void respuestaFallida() {
                Toast.makeText(getApplicationContext(), "No es posible establecer comunicación con el servicio, intente más tarde.", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void onStart() {
        super.onStart();
        if (!new Utileria(getApplicationContext()).esUsuarioConSesion()) {
            cerrarSesion();
        }
    }

    public void mostrarListaAlumnos(){
        Intent intentListaAlumnos = new Intent(this,ListaAlumnosActivity.class);
        startActivity(intentListaAlumnos);
    }


}