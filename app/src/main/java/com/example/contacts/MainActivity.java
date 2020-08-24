package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputNombreCompleto;
    private TextInputLayout textInputFechaNacimiento;
    private TextInputLayout textInputTelefono;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputDescripcionContacto;

    private TextInputEditText textInputDatePicker;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputNombreCompleto = findViewById(R.id.tilNombreCompleto);
        textInputFechaNacimiento = findViewById(R.id.tilDatePicker);
        textInputTelefono = findViewById(R.id.tilTelefono);
        textInputEmail = findViewById(R.id.tilEmail);
        textInputDescripcionContacto = findViewById(R.id.tilDescripcion);

        textInputDatePicker = findViewById(R.id.tietDatePicker);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        textInputDatePicker.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener,year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                textInputDatePicker.setText(date);
            }
        };
        textInputDatePicker.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        textInputDatePicker.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private boolean validateNombreCompleto(){
        String nombreCompletoInput = textInputNombreCompleto.getEditText().getText().toString().trim();

        if (nombreCompletoInput.isEmpty()){
            textInputNombreCompleto.setError(getResources().getString(R.string.empty_error));
            return false;
        }else{
            textInputNombreCompleto.setError(null);
            return true;
        }
    }
    private boolean validateFechaNacimiento(){
        String fechaNacimientoInput = textInputFechaNacimiento.getEditText().getText().toString().trim();

        if (fechaNacimientoInput.isEmpty()){
            textInputFechaNacimiento.setError(getResources().getString(R.string.empty_error));
            return false;
        }else{
            textInputFechaNacimiento.setError(null);
            return true;
        }
    }
    private boolean validateTelefono(){
        String telefonoInput = textInputTelefono.getEditText().getText().toString().trim();

        if (telefonoInput.isEmpty()){
            textInputTelefono.setError(getResources().getString(R.string.empty_error));
            return false;
        }else{
            textInputTelefono.setError(null);
            return true;
        }
    }
    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()){
            textInputEmail.setError(getResources().getString(R.string.empty_error));
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }

    public void siguienteActividad(View v){
        if (!validateNombreCompleto() | !validateFechaNacimiento() | !validateTelefono() | !validateEmail()){
            return;
        }
        Intent siguienteActividad = new Intent(MainActivity.this, ConfirmarDatos.class);
        siguienteActividad.putExtra(getResources().getString(R.string.p_nombre_completo), textInputNombreCompleto.getEditText().getText().toString());
        siguienteActividad.putExtra(getResources().getString(R.string.p_fecha_nacimiento), textInputFechaNacimiento.getEditText().getText().toString());
        siguienteActividad.putExtra(getResources().getString(R.string.p_telefono), textInputTelefono.getEditText().getText().toString());
        siguienteActividad.putExtra(getResources().getString(R.string.p_email), textInputEmail.getEditText().getText().toString());
        siguienteActividad.putExtra(getResources().getString(R.string.p_descripcion_contacto), textInputDescripcionContacto.getEditText().getText().toString());
        startActivity(siguienteActividad);
    }

    @Override
    public void onClick(View view) {

    }
}