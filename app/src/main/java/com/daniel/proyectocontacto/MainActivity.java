package com.daniel.proyectocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tNombre;
    TextInputLayout tTelefono;
    TextInputLayout tEmail;
    TextInputLayout tDescripcion;
    Button boton;
    DatePicker dpk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tNombre = (TextInputLayout) findViewById(R.id.tiNombre);
        tTelefono = (TextInputLayout) findViewById(R.id.tiTelefono);
        tEmail = (TextInputLayout) findViewById(R.id.tiEmail);
        tDescripcion = (TextInputLayout) findViewById(R.id.tiDescripcion);
        boton = (Button) findViewById(R.id.btnSiguiente);
        dpk = (DatePicker) findViewById(R.id.date);

        Bundle params = getIntent().getExtras();

        if(params != null)
        {
            tNombre.getEditText().setText(params.getString(getResources().getString(R.string.clvNombre)));
            tTelefono.getEditText().setText(params.getString(getResources().getString(R.string.clvTelefono)));
            tEmail.getEditText().setText(params.getString(getResources().getString(R.string.clvEmail)));
            tDescripcion.getEditText().setText(params.getString(getResources().getString(R.string.clvDescripcion)));
            int dia= Integer.valueOf(params.getString(getResources().getString(R.string.clvFechaD)));
            int mes= Integer.valueOf(params.getString(getResources().getString(R.string.clvFechaM)));
            int anio= Integer.valueOf(params.getString(getResources().getString(R.string.clvFechaA)));
            dpk.updateDate(anio,mes - 1, dia);

        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this , Confirmacion.class);
                intent.putExtra(getResources().getString(R.string.clvNombre),tNombre.getEditText().getText().toString());
                intent.putExtra(getResources().getString(R.string.clvFechaD),String.valueOf(dpk.getDayOfMonth()));
                intent.putExtra(getResources().getString(R.string.clvFechaM),String.valueOf(dpk.getMonth() + 1));
                intent.putExtra(getResources().getString(R.string.clvFechaA),String.valueOf(dpk.getYear()));
                intent.putExtra(getResources().getString(R.string.clvTelefono),tTelefono.getEditText().getText().toString());
                intent.putExtra(getResources().getString(R.string.clvEmail),tEmail.getEditText().getText().toString());
                intent.putExtra(getResources().getString(R.string.clvDescripcion),tDescripcion.getEditText().getText().toString());

                startActivity(intent);
                finish();
            }
        });
    }



}