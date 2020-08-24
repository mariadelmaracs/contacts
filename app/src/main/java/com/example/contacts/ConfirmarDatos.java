package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView ivNombreCompleto;
    TextView ivFechaNacimiento;
    TextView ivTelefono;
    TextView ivEmail;
    TextView ivDescripcionContacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_datos);

        Bundle extras = getIntent().getExtras();

        String nombreCompleto = extras.getString(getResources().getString(R.string.p_nombre_completo));
        String fechaNacimiento = extras.getString(getResources().getString(R.string.p_fecha_nacimiento));
        String telefono = extras.getString(getResources().getString(R.string.p_telefono));
        String email = extras.getString(getResources().getString(R.string.p_email));
        String descripcionContacto = extras.getString(getResources().getString(R.string.p_descripcion_contacto));

        ivNombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        ivFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        ivTelefono =  (TextView) findViewById(R.id.tvTelefono);
        ivEmail = (TextView) findViewById(R.id.tvEmail);
        ivDescripcionContacto = (TextView) findViewById(R.id.tvDescripcionContacto);

        ivNombreCompleto.setText(nombreCompleto);
        ivFechaNacimiento.setText(fechaNacimiento);
        ivTelefono.setText(telefono);
        ivEmail.setText(email);
        ivDescripcionContacto.setText(descripcionContacto);
    }

    public void editarDatos(View view){
        finish();
    }
}