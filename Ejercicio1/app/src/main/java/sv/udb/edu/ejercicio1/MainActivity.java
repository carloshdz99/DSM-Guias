package sv.udb.edu.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //tomando los campos
    private EditText a;
    private EditText b;
    private EditText c;
    private Button btncalcular;
    private TextView txtrespuesta;
    private TextView txtrespuesta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tomando por su id
        a = findViewById(R.id.numberA);
        b = findViewById(R.id.numberB);
        c = findViewById(R.id.numberC);
        btncalcular = findViewById(R.id.btncalcular);
        txtrespuesta = findViewById(R.id.txtrespuesta);
        txtrespuesta2 = findViewById(R.id.txtrespuesta2);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double na = Double.parseDouble(a.getText().toString());
                double nb = Double.parseDouble(b.getText().toString());
                double nc = Double.parseDouble(c.getText().toString());

                double xpositivo = (nb*(-1) + Math.sqrt(Math.pow(nb,2) - 4*na*nc)) / (2*na);
                double xnegativo = (nb*(1) + Math.sqrt(Math.pow(nb,2) - 4*na*nc)) / (2*na);
                txtrespuesta.setText(String.valueOf(xpositivo));
                txtrespuesta2.setText(String.valueOf(xnegativo));
            }
        });
    }
}