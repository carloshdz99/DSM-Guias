package sv.edu.udb.ejercicio02app;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText tv;
    private TextView tv1, tv2, tv3, tv4, tvn, tp1, tp2, tp3, tp4, tpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (EditText)findViewById(R.id.tv);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tvn = (TextView)findViewById(R.id.tvn);
        tp1 = (TextView)findViewById(R.id.tp1);
        tp2 = (TextView)findViewById(R.id.tp2);
        tp3 = (TextView)findViewById(R.id.tp3);
        tp4 = (TextView)findViewById(R.id.tp4);
        tpn = (TextView)findViewById(R.id.tpn);
    }

    public void Contar(View view){
        String valor = tv.getText().toString();
        String [] votosContados = valor.split("-");
        int cantidad = votosContados.length;
        int cand1 = 0, cand2 = 0, cand3 = 0, cand4 = 0, candn = 0;
        //Obtenemos cantidad de votos por candidato
        for (int i = 0; i < cantidad; i++) {
            if(votosContados[i].equals("1")){
                cand1++;
            } else if(votosContados[i].equals("2")){
                cand2++;
            } else if(votosContados[i].equals("3")){
                cand3++;
            } else if(votosContados[i].equals("4")){
                cand4++;
            } else {
                candn++;
            }
        }
        //Obteniendo los porcentajes
        double resp1 = Double.valueOf(cand1);
        resp1 = cand1*100/cantidad;

        double resp2 = Double.valueOf(cand2);
        resp2 = cand2*100/cantidad;

        double resp3 = Double.valueOf(cand3);
        resp3 = cand3*100/cantidad;

        double resp4 = Double.valueOf(cand4);
        resp4 = cand4*100/cantidad;

        double respn = Double.valueOf(candn);
        respn = candn*100/cantidad;
        //Convirtiendo respuestas a String
        String rv1 = String.valueOf(cand1);
        String rv2 = String.valueOf(cand2);
        String rv3 = String.valueOf(cand3);
        String rv4 = String.valueOf(cand4);
        String rvn = String.valueOf(candn);
        String rp1 = String.valueOf(resp1);
        String rp2 = String.valueOf(resp2);
        String rp3 = String.valueOf(resp3);
        String rp4 = String.valueOf(resp4);
        String rpn = String.valueOf(respn);
        //Asignando valores de votos y porcentajes porcentajes
        tv1.setText(rv1);
        tv2.setText(rv2);
        tv3.setText(rv3);
        tv4.setText(rv4);
        tvn.setText(rvn);
        tp1.setText(rp1);
        tp2.setText(rp2);
        tp3.setText(rp3);
        tp4.setText(rp4);
        tpn.setText(rpn);
    }
}