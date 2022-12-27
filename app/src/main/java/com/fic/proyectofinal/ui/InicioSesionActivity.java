package com.fic.proyectofinal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fic.proyectofinal.R;
import com.fic.proyectofinal.data.api.RespuestaPersonalizada;
import com.fic.proyectofinal.data.entidades.Profesor;
import com.fic.proyectofinal.domain.DominioProfesor;
import com.fic.proyectofinal.utils.Constantes;

import java.util.List;

public class InicioSesionActivity extends AppCompatActivity {

    private Button btnIniciarSesion;
    private EditText etNombreUsuario, etContraseniaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        etNombreUsuario = findViewById(R.id.etNombreUsuario);
        etContraseniaUsuario = findViewById(R.id.etContraseniaUsuario);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(accionBotonIniciarSesion);

    }


    private View.OnClickListener accionBotonIniciarSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String usuario = etNombreUsuario.getText().toString();
            String contrasenia = etContraseniaUsuario.getText().toString();
            if(validarCamposInicioSesion(usuario,contrasenia)){
                autenticarUsuario(Integer.parseInt(usuario),contrasenia);
            }else{
                Toast.makeText(getApplicationContext(),"Complete los campos para poder iniciar sesión", Toast.LENGTH_LONG).show();
            }
        }
    };

    public void autenticarUsuario(int numero, String contrasena) {
        DominioProfesor dominioProfesor = new DominioProfesor();
        dominioProfesor.obtenerDatosProfesor(numero,contrasena, new RespuestaPersonalizada<Profesor>() {
            @Override
            public void respuestaSatisfactoria(List<Profesor> respuesta) {

                if(respuesta.size() > 0){
                    Intent intent = new Intent(getApplicationContext(),TableroPrincipalActivity.class);
                    startActivity(intent);
                    almacenarPreferenciasUsuario(respuesta.get(0));
                }else{
                    Toast.makeText(getApplicationContext(),"No es posible validar los datos de acceso, intente de nuevo.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void respuestaFallida() {
                Toast.makeText(getApplicationContext(),"No es posible establecer comunicación con el servicio, intente más tarde.", Toast.LENGTH_LONG).show();
            }
        });
    }



    public SharedPreferences obtenerPreferenciasUsuario(){
        return getSharedPreferences(Constantes.PREFERENCIAS_USUARIO, Context.MODE_PRIVATE);
    }

    public void almacenarPreferenciasUsuario(Profesor datosProfesor){
        SharedPreferences.Editor editarPreferencias = obtenerPreferenciasUsuario().edit();
        editarPreferencias.putInt(Constantes.CLAVE_ID_CURSO,datosProfesor.getIdCurso());
        editarPreferencias.putString(Constantes.CLAVE_NOMBRE_CURSO,datosProfesor.getCurso());
        editarPreferencias.putInt(Constantes.CLAVE_ID_PROFESOR,datosProfesor.getId());
        editarPreferencias.putString(Constantes.CLAVE_NOMBRE_PROFESOR,datosProfesor.getNombre());
        editarPreferencias.putInt(Constantes.CLAVE_SESION_ACTIVA,1);
        editarPreferencias.apply();
    }

    public boolean validarCamposInicioSesion(String usuario, String contrasenia){
        return usuario.length() > 0 &&  contrasenia.length() > 0;
    }
}