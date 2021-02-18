package sv.udb.edu.ejerciciolab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DatosOperario extends AppCompatActivity {

    private TextView tvSueldo;
    private TextView tvAños;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_operario);
    }
}