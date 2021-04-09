package com.beautyapp;

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

    private Button btnLogin, btnRegistro;
    private EditText edtusuario, edtContraseña;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_BeautyAppDsm);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //iniciando firebase
        mAuth = FirebaseAuth.getInstance();

        //ejecutando inicializacion de variables
        init();

        //evento login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEmailandPassword();
            }
        });

        //evento registrarse
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
            }
        });
    }

    //metodo de logueo con firebase
    private  void LoginEmailandPassword(){
        String usuario, contraseña;
        usuario = edtusuario.getText().toString();
        contraseña = edtContraseña.getText().toString();

        mAuth.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //inicializando variables
    private void init(){
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistro = findViewById(R.id.btnRegistro);

        edtusuario = findViewById(R.id.edtRegisUsuario);
        edtContraseña = findViewById(R.id.edtRegisContraseña);
    }
}