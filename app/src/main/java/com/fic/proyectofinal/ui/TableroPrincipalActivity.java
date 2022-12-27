package com.fic.proyectofinal.ui;

import androidx.appcompat.app.ActionBar;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fic.proyectofinal.R;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.entidades.Curso;
import com.fic.proyectofinal.domain.DominioCurso;
import com.fic.proyectofinal.utils.Constantes;
import com.fic.proyectofinal.utils.Utileria;

import java.util.List;

public class TableroPrincipalActivity extends BaseActivity {

    TextView txtPromedioGeneralCurso, txtNumeroAlumnosAprobados, txtNumeroAlumnosReprobados, txtNombreProfesor, txtNombreCurso;
    Button btnListaAlumnos;
    private int idCurso;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero_principal);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Constantes.TABLERO_PRINCIPAL);
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_fic)));
        }

        txtPromedioGeneralCurso = findViewById(R.id.txtPromedioGeneral);
        txtNumeroAlumnosAprobados = findViewById(R.id.txtNumeroAlumnosAprobados);
        txtNumeroAlumnosReprobados = findViewById(R.id.txtNumeroAlumnosReprobados);
        txtNombreProfesor = findViewById(R.id.txtNombreProfesor);
        txtNombreCurso = findViewById(R.id.txtNombreCurso);
        btnListaAlumnos = findViewById(R.id.btnListaAlumnos);

        btnListaAlumnos.setOnClickListener(accionBotonAlumnos);
        idCurso = new Utileria(getApplicationContext()).obtenerIdCurso();
        mostrarIndicadoresGeneralesCurso(idCurso);
    }

    public void mostrarIndicadoresGeneralesCurso(int idCurso) {
        DominioCurso dominioCurso = new DominioCurso();
        dominioCurso.obtenerIndicadoresGeneralesCurso(idCurso, new RespuestaPersonalizada<Curso>() {
            @Override
            public void respuestaSatisfactoria(List<Curso> respuesta) {
                txtPromedioGeneralCurso.setText(respuesta.get(0).getPromedioGeneral());
                txtNumeroAlumnosAprobados.setText(respuesta.get(0).getAlumnosAprobados());
                txtNumeroAlumnosReprobados.setText(respuesta.get(0).getAlumnosReprobados());
                txtNombreProfesor.setText("Profesor: "+ new Utileria(getApplicationContext()).obtenerNombreProfesor());
                txtNombreCurso.setText("Curso: " + new Utileria(getApplicationContext()).obtenerNombreCurso());

            }

            @Override
            public void respuestaFallida() {
                Toast.makeText(getApplicationContext(), "No es posible establecer comunicación con el servicio, intente más tarde.", Toast.LENGTH_LONG).show();

            }
        });
    }

    private View.OnClickListener accionBotonAlumnos = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ListaAlumnosActivity.class);
            startActivity(intent);
        }
    };

    public void onResume() {
        super.onResume();
        mostrarIndicadoresGeneralesCurso(idCurso);
    }

    public void onStart() {
        super.onStart();
        if (!new Utileria(getApplicationContext()).esUsuarioConSesion()) {
            cerrarSesion();
        }
    }

}