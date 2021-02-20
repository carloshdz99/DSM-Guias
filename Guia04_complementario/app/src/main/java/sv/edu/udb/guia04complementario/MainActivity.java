package sv.edu.udb.guia04complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etHoras;
    private Double costoHora=8.50;
    private Double salarioNeto;
    private Double salarioBase;
    private Double isss;
    private Double afp;
    private Double renta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=(EditText)findViewById(R.id.textNombre);
        etHoras=(EditText)findViewById(R.id.textHoras);
    }

    public void segundaActividad(View view) {

        salarioBase = costoHora * Double.parseDouble(etHoras.getText().toString());
        isss = salarioBase * 0.02;
        afp = salarioBase * 0.03;
        renta = salarioBase * 0.04;
        salarioNeto= salarioBase - isss - afp - renta;


        Intent i=new Intent(this, segundaActividad.class);
        i.putExtra("txtNombre", etNombre.getText().toString());
        i.putExtra("txtISSS", String.valueOf(isss));
        i.putExtra("txtAFP", String.valueOf(afp));
        i.putExtra("txtRENTA", String.valueOf(renta));
        i.putExtra("txtNETO", String.valueOf(salarioNeto));
        startActivity(i);

    }
}