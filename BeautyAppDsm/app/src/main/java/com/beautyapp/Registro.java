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

public class Registro extends AppCompatActivity {

    private Button btnIngresar, btnRegistrarse;
    private EditText edtUsuario, edtContraseña, edtContraseña2;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        //iniciando variables
        init();

        //evento registrarse
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterEmailandPassword();
            }
        });

        //evento ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registro.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    //metodo de registro con firebase
    private void RegisterEmailandPassword(){
        String usuario, contraseña1, contraseña2;
        usuario = edtUsuario.getText().toString();
        contraseña1 = edtContraseña.getText().toString();
        contraseña2 = edtContraseña2.getText().toString();

        if (contraseña1 == contraseña2){
            mAuth.createUserWithEmailAndPassword(usuario, contraseña1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Cuenta registrada", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Registro.this, MainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "No fue posible crearse la cuenta", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }else {
            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }
    }

    //inicializando variables
    private void init(){
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.btnRegistro);

        edtContraseña = findViewById(R.id.edtRegisContraseña);
        edtContraseña2 = findViewById(R.id.edtRegisContraseña2);
        edtUsuario = findViewById(R.id.edtRegisUsuario);
    }
}