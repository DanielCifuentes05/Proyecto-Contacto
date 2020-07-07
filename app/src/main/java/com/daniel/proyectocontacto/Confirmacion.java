package com.daniel.proyectocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {


    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        edit = (Button) findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString(getResources().getString(R.string.clvNombre));
        final String dia = parametros.getString(getResources().getString(R.string.clvFechaD));
        final String mes = parametros.getString(getResources().getString(R.string.clvFechaM));
        final String anio = parametros.getString(getResources().getString(R.string.clvFechaA));
        final String tel = parametros.getString(getResources().getString(R.string.clvTelefono));
        final String email = parametros.getString(getResources().getString(R.string.clvEmail));
        final String desc = parametros.getString(getResources().getString(R.string.clvDescripcion));
        String fecha = dia + "/" + mes + "/"+ anio;

        TextView trNombre = (TextView) findViewById(R.id.tvNombre);
        TextView trFecha = (TextView) findViewById(R.id.resFecha);
        TextView trTelefono = (TextView) findViewById(R.id.resTelefono);
        TextView trEmail = (TextView) findViewById(R.id.resEmail);
        TextView trDescripcion = (TextView) findViewById(R.id.resDescripcion);

        trNombre.setText(nombre);
        trFecha.setText(fecha);
        trTelefono.setText(tel);
        trEmail.setText(email);
        trDescripcion.setText(desc);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Confirmacion.this , MainActivity.class);
                intent.putExtra(getResources().getString(R.string.clvNombre), nombre);
                intent.putExtra(getResources().getString(R.string.clvTelefono), tel);
                intent.putExtra(getResources().getString(R.string.clvEmail), email);
                intent.putExtra(getResources().getString(R.string.clvDescripcion), desc);
                intent.putExtra(getResources().getString(R.string.clvFechaD), dia);
                intent.putExtra(getResources().getString(R.string.clvFechaM), mes);
                intent.putExtra(getResources().getString(R.string.clvFechaA), anio);

                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==  KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Confirmacion.this , MainActivity.class);
            startActivity(intent);

        }
        return super.onKeyDown(keyCode, event);
    }
}