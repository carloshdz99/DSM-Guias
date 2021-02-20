package sv.edu.udb.guia04complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class segundaActividad extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvISSS;
    private TextView tvAFP;
    private TextView tvRENTA;
    private TextView tvNETO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        tvNombre=(TextView)findViewById(R.id.textViewNOMBRE);
        tvISSS=(TextView)findViewById(R.id.textViewISSS);
        tvAFP=(TextView)findViewById(R.id.textViewAFP);
        tvRENTA=(TextView)findViewById(R.id.textViewRENTA);
        tvNETO=(TextView)findViewById(R.id.textViewNETO);
        Bundle bundle = getIntent().getExtras();
        String nombre=bundle.getString("txtNombre");
        String isss=bundle.getString("txtISSS");
        String afp=bundle.getString("txtAFP");
        String renta=bundle.getString("txtRENTA");
        String neto=bundle.getString("txtNETO");
        tvNombre.setText(nombre);
        tvISSS.setText(isss);
        tvAFP.setText(afp);
        tvRENTA.setText(renta);
        tvNETO.setText(neto);
    }

    public void finalizar(View view) {
        finish();
    }
}