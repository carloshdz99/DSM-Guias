package sv.udb.edu.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class DatosEmpleados extends AppCompatActivity {
    private TextView tvnombre1;
    private TextView tvapellido1;
    private TextView tvcargo1;
    private TextView tvhoras1;
    private TextView tvsueldo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_empleados);

        //tomando texview para mostrar informacion
        tvnombre1 = findViewById(R.id.nombres1);
        tvapellido1 = findViewById(R.id.apellidos1);
        tvcargo1 = findViewById(R.id.cargo1);
        tvhoras1 = findViewById(R.id.horas1);
        tvsueldo1 = findViewById(R.id.sueldo1);

        //obteniendo datos pasados de la actividad anterior
        Bundle bundle = getIntent().getExtras();
        String nombre1 = bundle.getString("nombres1");
        String apellido1 = bundle.getString("apellidos1");
        String cargo1 = bundle.getString("cargo1");
        String hora1 = bundle.getString("horas1");
        String sueldo1 = bundle.getString("sueldo1");

        //cambiando el texto de los textview
        tvnombre1.setText(nombre1);
        tvapellido1.setText(apellido1);
        tvcargo1.setText(cargo1);
        tvhoras1.setText(hora1);
        tvsueldo1.setText(sueldo1);
    }
}