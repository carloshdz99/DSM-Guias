package sv.udb.edu.ejerciciolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declarando variables
    private EditText sueldo;
    private EditText años;
    private Button btncalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tomando los campos a ingresar y el boton por su id
        sueldo=(EditText)findViewById(R.id.nSueldo);
        años = (EditText)findViewById(R.id.nAños);
        btncalcular = findViewById(R.id.btncalcular);

        //evento del boton que calculara el sueldo
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //realizando conversion
               calcular(view);

            }
        });
    }


    public void calcular(View view) {
        //realizando conversion
        int Naños = Integer.parseInt(años.getText().toString());
        double Nsueldo = Double.parseDouble(sueldo.getText().toString());
        String aumento = "";
        sueldo.setError(null);
        años.setError(null);
        // Comparar si está en el rango
        if (Nsueldo >= 100 && Naños >=1) {
            // La validación termina y hacemos lo que vayamos a hacer
            Toast.makeText(MainActivity.this, "Todo correcto", Toast.LENGTH_SHORT).show();
            //validaciones de sueldo
            if ((Nsueldo >= 100 && Nsueldo < 500) && Naños >= 10) {
                Nsueldo = Nsueldo + (Nsueldo * 0.2);
                aumento = "20%";
            } else if ((Nsueldo >= 100 && Nsueldo < 500) && Naños < 10) {
                Nsueldo = Nsueldo + (Nsueldo * 0.05);
                aumento = "5%";
            } else if (Nsueldo >= 500) {
                aumento = "0%";
            }
            Intent i = new Intent(this, DatosOperario.class);
            i.putExtra("sueldo", String.valueOf(Nsueldo));
            i.putExtra("años", String.valueOf(Naños));
            i.putExtra("aumento", aumento);
            startActivity(i);

        } else {
            // Si no, entonces indicamos el error y damos focus
            sueldo.setError("Número fuera de rango");
            años.setError("Años fuera de rango");
            sueldo.requestFocus();
        }
    }
}