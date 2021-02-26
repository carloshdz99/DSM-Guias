package sv.udb.edu.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declarando variables a utilizar
    private EditText nombreEm1, nombreEm2, nombreEm3;
    private EditText apellidoEm1, apellidoEm2, apellidoEm3;
    private EditText cargoEm1, cargoEm2, cargoEm3;
    private EditText horasEm1, horasEm2, horasEm3;
    private Button btncalcularSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tomando los campos de las activity
        nombreEm1 = findViewById(R.id.edtnombres1);
        nombreEm2 = findViewById(R.id.edtnombres2);
        nombreEm3 = findViewById(R.id.edtnombres3);
        apellidoEm1 = findViewById(R.id.edtapellidos1);
        apellidoEm2 = findViewById(R.id.edtapellidos2);
        apellidoEm3 = findViewById(R.id.edtapellidos3);
        cargoEm1 = findViewById(R.id.edtcargoempleado1);
        cargoEm2 = findViewById(R.id.edtcargoempleado2);
        cargoEm3 = findViewById(R.id.edtcargoempleado3);
        horasEm1 = findViewById(R.id.edthorasmes1);
        horasEm2 = findViewById(R.id.edthorasmes2);
        horasEm3 = findViewById(R.id.edthorasmes3);
        btncalcularSueldo = findViewById(R.id.btncalcularsalarios);

        btncalcularSueldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviandoDatos(v);
            }
        });
    }

    //enviando datos a la segunda actividad
    public void enviandoDatos(View view){
        //notificacion de error
        Toast error = Toast.makeText(this, "No se permiten ceros ni negativos", Toast.LENGTH_LONG);
        //tomando horas
        int hora1 = Integer.parseInt(horasEm1.getText().toString());
        int hora2 = Integer.parseInt(horasEm2.getText().toString());
        int hora3 = Integer.parseInt(horasEm3.getText().toString());
        //tomando cargos
        String cargo1 = cargoEm1.getText().toString();
        //variables de sueldos
        double sueldo1;
        double sueldoliquido1=0;
        double bono1=0;

        //validando numeros negativos
        if(hora1<=0 || hora2<=0 || hora3<=0){
            error.show();
        }else {
            //////////////////////////////////////
            //validando horas empleado 1
            if (hora1 <= 160){
                sueldo1 = hora1*9.75;
                sueldoliquido1 = sueldo1 - (sueldo1*0.0525) - (sueldo1*0.0688) - (sueldo1*0.1);
                if(cargo1=="gerente"){
                    bono1 = sueldoliquido1*0.1;
                    sueldoliquido1 = sueldoliquido1 + bono1;
                }else if(cargo1 == "asistente"){
                    bono1 = sueldoliquido1*0.05;
                    sueldoliquido1 = sueldoliquido1 + bono1;
                }else if(cargo1 == "secretaria"){
                    bono1 = sueldoliquido1*0.02;
                    sueldoliquido1 = sueldoliquido1 + bono1;
                }
            }else if(hora1 > 160){
                sueldo1 = 160*9.75 + ((hora1-160)*11.50);
                sueldoliquido1 = sueldo1 - (sueldo1*0.0525) - (sueldo1*0.0688) - (sueldo1*0.1);
                if(cargo1=="gerente"){
                    bono1 = sueldoliquido1*0.1;
                    sueldoliquido1 = sueldoliquido1 + bono1;
                }else if(cargo1 == "asistente"){
                    bono1 = sueldoliquido1*0.05;
                    sueldoliquido1 = sueldoliquido1 + bono1;
                }else if(cargo1 == "secretaria"){
                    bono1 = sueldoliquido1*0.02;
                    sueldoliquido1 = sueldoliquido1 + bono1;
                }
            }
            //fin validacion empleado 1
            //////////////////////////////////////

            /////////////////////////////////////
            //mandando datos a la segunda activity
            Intent i= new Intent(this, DatosEmpleados.class);
            i.putExtra("nombres1", nombreEm1.getText().toString());
            i.putExtra("apellidos1", apellidoEm1.getText().toString());
            i.putExtra("cargo1", cargoEm1.getText().toString());
            i.putExtra("horas1", horasEm1.getText().toString());
            i.putExtra("sueldo1", String.valueOf(sueldoliquido1));
        }
    }
}

