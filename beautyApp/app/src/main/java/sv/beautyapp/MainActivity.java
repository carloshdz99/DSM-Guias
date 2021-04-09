package sv.beautyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //iniciando campos de texto y botones
    private Button btnLogin;
    private EditText edtUsuario, edtContraseña;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //cambiando estilo de tema despues de cargada la aplicacion
        setTheme(R.style.Theme_BeautyApp);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ocultando la actionbar
        getSupportActionBar().hide();

        init();

        //iniciando firebase
        mAuth = FirebaseAuth.getInstance();

        //evento login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Dashboard.class);
                startActivity(i);
               // LoginEmailandPassword();
            }
        });

    }

    private void LoginEmailandPassword(){
        String usuario, contraseña;
        usuario = edtUsuario.getText().toString();
        contraseña = edtContraseña.getText().toString();
        mAuth.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "se ha iniciado sesion", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, Registro.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Fallo el inicio de sesion", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //inicializando variables
    private void init(){
        edtUsuario = findViewById(R.id.edtUsuario);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnLogin = findViewById(R.id.btnLogin);
    }
}