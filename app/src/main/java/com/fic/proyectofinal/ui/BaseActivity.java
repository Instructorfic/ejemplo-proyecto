package com.fic.proyectofinal.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.fic.proyectofinal.R;
import com.fic.proyectofinal.utils.Utileria;

public class BaseActivity extends AppCompatActivity {


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.itemCerrarSesion){
            cerrarSesion();
        }
        return super.onOptionsItemSelected(item);
    }

    public void cerrarSesion(){
        eliminarPreferencias();
        Intent intent = new Intent(getApplicationContext(), InicioSesionActivity.class);
        startActivity(intent);
        finish();
    }

    public void eliminarPreferencias(){
        SharedPreferences preferenciasUsuario = new Utileria(getApplicationContext()).obtenerPreferenciasUsuario();
        preferenciasUsuario.edit().clear().commit();
    }

}
