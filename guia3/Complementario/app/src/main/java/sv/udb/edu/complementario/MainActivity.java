package sv.udb.edu.complementario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private int contador=0;

    TextView labelTextView;
    Button btnsuma;
    //integer suma
    SumaViewModel sumaViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelTextView = findViewById(R.id.txtnumber);
        btnsuma = findViewById(R.id.btnsuma);

        //boton de suma
        btnsuma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                addNumero();
               /* contador++;
                if(contador==10){
                    contador=0;
                    label.setText(""+contador+"");
                }else {
                    label.setText(""+contador+"");
                }*/
            }
        });

        sumaViewModel = new ViewModelProvider(this).get(SumaViewModel.class);
        labelTextView.setText(String.valueOf(sumaViewModel.getSuma()));

        //sumando valor con el boton
    }
    public void addNumero(){
        sumaViewModel.addSuma();
        labelTextView.setText(String.valueOf(sumaViewModel.getSuma()));
    }
}