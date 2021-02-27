package sv.udb.edu.ejercicio3empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables empleados
    private EditText txtnombres1, txtapellidos1, txtcargo1, txthoras1;
    private EditText txtnombres2, txtapellidos2, txtcargo2, txthoras2;
    private EditText txtnombres3, txtapellidos3, txtcargo3, txthoras3;
    //variable boton
    private Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tomando los campos de la activity
        //empleado1
        txtnombres1 = findViewById(R.id.txtnombre1);
        txtapellidos1 = findViewById(R.id.txtapellidos1);
        txtcargo1 = findViewById(R.id.txtcargo1);
        txthoras1 = findViewById(R.id.nhoras1);
        //empleado2
        txtnombres2 = findViewById(R.id.txtnombres2);
        txtapellidos2 = findViewById(R.id.txtapellidos2);
        txtcargo2 = findViewById(R.id.txtcargo2);
        txthoras2 = findViewById(R.id.nhoras2);
        //empleado3
        txtnombres3 = findViewById(R.id.txtnombres3);
        txtapellidos3 = findViewById(R.id.txtapellidos3);
        txtcargo3 = findViewById(R.id.txtcargo3);
        txthoras3 = findViewById(R.id.nhoras3);
        //tomando boton de la activity
        btncalcular = findViewById(R.id.btncalcular);

        //evendo del boton calcular
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcular_sueldo(v);
            }
        });
    }



    //metodo para calcular
    public void Calcular_sueldo(View view){
        //enviando datos a la segunda activity
        Intent i = new Intent(this, DatosEmpleados.class);

        double porbono1 = 0, porbono2 = 0, porbono3=0;
        //creando costos hora
        double sueldo1, sueldo2, sueldo3;
        double sueldoliquido1, sueldoliquido2, sueldoliquido3;
        //tomando cargos
        String cargo1 = txtcargo1.getText().toString();
        String cargo2 = txtcargo2.getText().toString();
        String cargo3 = txtcargo3.getText().toString();
        //tomando horas
        int horas1 = Integer.parseInt(txthoras1.getText().toString());
        int horas2 = Integer.parseInt(txthoras2.getText().toString());
        int horas3 = Integer.parseInt(txthoras3.getText().toString());

        //validando horas
        if (horas1 <=0 || horas2<=0 || horas3<=0){
            Toast msg = Toast.makeText(this, "No se permiten ceros ni negativos", Toast.LENGTH_LONG);
            msg.show();
        }else {
            //validando bonos
            //&&
            if (cargo1.equals("gerente") && cargo2.equals("asistente") && cargo3.equals("secretaria")){
                porbono1 = 0;
                porbono2 = 0;
                porbono3 = 0;
                i.putExtra("bono", "No hay bono");
            }else {
                i.putExtra("bono", "Si hay bono");
                //cargo1
                if (cargo1.equals("gerente")){
                   porbono1 = 0.1;
                }else if (cargo1.equals("asistente")){
                   porbono1 = 0.05;
                }else if (cargo1.equals("secretaria")){
                   porbono1 = 0.03;
                }else{
                   porbono1 = 0.02;
                }
                //cargo2
                if (cargo2 == "gerente" ){
                   porbono2 = 0.1;
                }else if (cargo2=="asistente"){
                   porbono2 = 0.05;
                }else if (cargo2=="secretaria"){
                   porbono2 = 0.03;
                }else {
                   porbono2 = 0.02;
                }
                //cargo3
                if (cargo3 == "gerente" ){
                    porbono3 = 0.1;
                }else if (cargo3=="asistente"){
                    porbono3 = 0.05;
                }else if (cargo3=="secretaria"){
                    porbono3 = 0.03;
                }else {
                    porbono3 = 0.02;
                }
            }
            //fin validacion bonos
            //calculando sueldos
            //sueldo1
            if (horas1 <=160){
                sueldo1 = horas1*9.75;
                sueldoliquido1 = sueldo1 - (sueldo1*0.0525) - (sueldo1*0.0688) - (sueldo1*0.1);
                sueldoliquido1 = sueldoliquido1 + (sueldoliquido1*porbono1);
            }else {
                sueldo1 = 160*9.75 + (horas1-160)*11.50;
                sueldoliquido1 = sueldo1 - (sueldo1*0.0525) - (sueldo1*0.0688) - (sueldo1*0.1);
                sueldoliquido1 = sueldoliquido1 + (sueldoliquido1*porbono1);
            }
            //sueldo2
            if (horas2 <=160){
                sueldo2 = horas2*9.75;
                sueldoliquido2 = sueldo2 - (sueldo2*0.0525) - (sueldo2*0.0688) - (sueldo2*0.1);
                sueldoliquido2 = sueldoliquido2 + (sueldoliquido2*porbono2);
            }else {
                sueldo2 = 160*9.75 + (horas1-160)*11.50;
                sueldoliquido2 = sueldo2 - (sueldo2*0.0525) - (sueldo2*0.0688) - (sueldo2*0.1);
                sueldoliquido2 = sueldoliquido2 + (sueldoliquido2*porbono2);
            }
            //sueldo3
            if (horas3 <=160){
                sueldo3 = horas3*9.75;
                sueldoliquido3 = sueldo3 - (sueldo3*0.0525) - (sueldo3*0.0688) - (sueldo3*0.1);
                sueldoliquido3 = sueldoliquido3 + (sueldoliquido3*porbono3);
            }else {
                sueldo3 = 160*9.75 + (horas3-160)*11.50;
                sueldoliquido3 = sueldo3 - (sueldo3*0.0525) - (sueldo3*0.0688) - (sueldo3*0.1);
                sueldoliquido3 = sueldoliquido3 + (sueldoliquido3*porbono3);
            }
            //fin calculo de sueldos



            //validando cual es el sueldo mayor de todos
            if (sueldoliquido1>=sueldoliquido2 && sueldoliquido1>=sueldoliquido3){
                i.putExtra("empleadomayorsueldo", txtnombres1.getText().toString());
            }else if (sueldoliquido2>=sueldoliquido1 && sueldoliquido2>=sueldoliquido3){
                i.putExtra("empleadomayorsueldo", txtnombres2.getText().toString());
            }else if(sueldoliquido3>=sueldoliquido1 && sueldoliquido3>=sueldoliquido2){
                i.putExtra("empleadomayorsueldo", txtnombres3.getText().toString());
            }

            //validando cual es el sueldo menor de todos
            if (sueldoliquido1<=sueldoliquido2 && sueldoliquido1<=sueldoliquido3){
                i.putExtra("empleadomenorsueldo", txtnombres1.getText().toString());
            }else if (sueldoliquido2<=sueldoliquido1 && sueldoliquido2<=sueldoliquido3){
                i.putExtra("empleadomenorsueldo", txtnombres2.getText().toString());
            }else if(sueldoliquido3<=sueldoliquido1 && sueldoliquido3<=sueldoliquido2){
                i.putExtra("empleadomenorsueldo", txtnombres3.getText().toString());
            }

            //calculando sueldos mayores de 300
            int k=0;
            double[] sueldos = {sueldoliquido1, sueldoliquido2, sueldoliquido3};
            for (int j=0; j<sueldos.length; j++){
                if (sueldos[j] > 300){
                    k=k+1;
                }
            }
            i.putExtra("mayoresatrescientos", String.valueOf(k));

            //enviando datos empleado 1
            i.putExtra("nombres1", txtnombres1.getText().toString());
            i.putExtra("apellidos1", txtapellidos1.getText().toString());
            i.putExtra("cargo1", cargo1);
            i.putExtra("sueldo1", String.valueOf(sueldoliquido1));
            //enviando datos empleado 2
            i.putExtra("nombres2", txtnombres2.getText().toString());
            i.putExtra("apellidos2", txtapellidos2.getText().toString());
            i.putExtra("cargo2", cargo2);
            i.putExtra("sueldo2", String.valueOf(sueldoliquido2));
            //enviando datos empleado 3
            i.putExtra("nombres3", txtnombres3.getText().toString());
            i.putExtra("apellidos3", txtapellidos3.getText().toString());
            i.putExtra("cargo3", cargo3);
            i.putExtra("sueldo3", String.valueOf(sueldoliquido3));
            startActivity(i);
        }

    }
}