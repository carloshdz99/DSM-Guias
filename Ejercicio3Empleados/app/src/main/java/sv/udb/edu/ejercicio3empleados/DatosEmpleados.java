package sv.udb.edu.ejercicio3empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosEmpleados extends AppCompatActivity {
    private TextView tvnombres1, tvapellidos1, tvcargo1, tvsueldo1;
    private TextView tvnombres2, tvapellidos2, tvcargo2, tvsueldo2;
    private TextView tvnombres3, tvapellidos3, tvcargo3, tvsueldo3;

    private TextView tvmayor, tvmenor, tvmayorestrescientos;

    private TextView tvbono;

    private Button btnregesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_empleados);
        //instancia recibiendo datos
        Bundle bundle = getIntent().getExtras();

        btnregesar = findViewById(R.id.btnregresar);

        //variables empleado 1
        tvnombres1 = findViewById(R.id.tvnombres1);
        tvapellidos1 = findViewById(R.id.tvapellidos1);
        tvcargo1 = findViewById(R.id.tvcargo1);
        tvsueldo1 = findViewById(R.id.tvsueldo1);
        String nombres1 = bundle.getString("nombres1");
        String apellidos1 = bundle.getString("apellidos1");
        String cargo1 = bundle.getString("cargo1");
        String sueldo1 = bundle.getString("sueldo1");
        tvnombres1.setText(nombres1);
        tvapellidos1.setText(apellidos1);
        tvcargo1.setText(cargo1);
        tvsueldo1.setText(sueldo1);

        //variables empleado 2
        tvnombres2 = findViewById(R.id.tvnombres2);
        tvapellidos2 = findViewById(R.id.tvapellidos2);
        tvcargo2 = findViewById(R.id.tvcargo2);
        tvsueldo2 = findViewById(R.id.tvsueldo2);
        String nombres2 = bundle.getString("nombres2");
        String apellidos2 = bundle.getString("apellidos2");
        String cargo2 = bundle.getString("cargo2");
        String sueldo2 = bundle.getString("sueldo2");
        tvnombres2.setText(nombres2);
        tvapellidos2.setText(apellidos2);
        tvcargo2.setText(cargo2);
        tvsueldo2.setText(sueldo2);

        //variables empleado 3
        tvnombres3 = findViewById(R.id.tvnombres3);
        tvapellidos3 = findViewById(R.id.tvapellidos3);
        tvcargo3 = findViewById(R.id.tvcargo3);
        tvsueldo3 = findViewById(R.id.tvsueldo3);
        String nombres3 = bundle.getString("nombres3");
        String apellidos3 = bundle.getString("apellidos3");
        String cargo3 = bundle.getString("cargo3");
        String sueldo3 = bundle.getString("sueldo3");
        tvnombres3.setText(nombres3);
        tvapellidos3.setText(apellidos3);
        tvcargo3.setText(cargo3);
        tvsueldo3.setText(sueldo3);

        //variables mensajes
        tvmayor = findViewById(R.id.tvmayorsueldo);
        String mayorsueldo = bundle.getString("empleadomayorsueldo");
        tvmayor.setText(mayorsueldo);
        tvmenor = findViewById(R.id.tvmenorsueldo);
        String menorsueldo = bundle.getString("empleadomenorsueldo");
        tvmenor.setText(menorsueldo);
        tvmayorestrescientos = findViewById(R.id.tvmayoresatrescientos);
        String mayoresatrescientos = bundle.getString("mayoresatrescientos");
        tvmayorestrescientos.setText(mayoresatrescientos);

        //mostrando si hay bono o no
        tvbono = findViewById(R.id.tvbono);
        String bono = bundle.getString("bono");
        tvbono.setText(bono);

        //regresando a la primera activity
        btnregesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}