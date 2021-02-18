package sv.udb.edu.ejerciciolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText sueldo;
    private EditText años;
    private Button btncalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sueldo=(EditText)findViewById(R.id.nSueldo);
        años = (EditText)findViewById(R.id.nAños);
        btncalcular = findViewById(R.id.btncalcular);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

            }
        });
    }


    public void calcular(View view){
        Intent i = new Intent(this, DatosOperario.class);
        i.putExtra("sueldo", sueldo.getText().toString());
        i.putExtra("años", años.getText().toString());
        startActivity(i);
    }
}