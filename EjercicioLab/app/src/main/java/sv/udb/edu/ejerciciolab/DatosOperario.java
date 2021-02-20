package sv.udb.edu.ejerciciolab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DatosOperario extends AppCompatActivity {

    private TextView tvSueldo;
    private TextView tvAños;
    private TextView tvaumento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_operario);

        Bundle bundle = getIntent().getExtras();
        String Nsueldo = bundle.getString("sueldo");
        String Naños = bundle.getString("años");
        String Naumento = bundle.getString("aumento");

        Toast notification = Toast.makeText(this, "El sueldo del operario es: "+Nsueldo+"", Toast.LENGTH_LONG);
        notification.show();
        Toast notification2 = Toast.makeText(this, "Los años del operario son del operario es: "+Naños+"", Toast.LENGTH_LONG);
        notification2.show();

        //asignando textos a textview
        tvSueldo = (TextView)findViewById(R.id.datoSueldo);
        tvSueldo.setText(Nsueldo);
        tvaumento = (TextView)findViewById(R.id.datoAumento);
        tvaumento.setText(Naumento);
        tvAños = (TextView)findViewById(R.id.datoAños);
        tvAños.setText(Naños);

    }
}