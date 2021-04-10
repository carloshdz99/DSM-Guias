package com.beautyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    private static final String TAG = "Firebase";
    private Button btnIngresar, btnRegistrarse;
    private EditText edtUsuario, edtContraseña;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        //iniciando firebase
        mAuth = FirebaseAuth.getInstance();

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
        String usuario, contraseña;
        usuario = edtUsuario.getText().toString();
        contraseña = edtContraseña.getText().toString();

        if (TextUtils.isEmpty(usuario)){
            Toast.makeText(getApplicationContext(), "Por favor ingrese su correo", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(getApplicationContext(), "Por favor ingrese su contraseña", Toast.LENGTH_LONG).show();
            return;
        }

            mAuth.createUserWithEmailAndPassword(usuario, contraseña).
                    addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Cuenta registrada", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Registro.this, MainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "No fue posible crearse la cuenta", Toast.LENGTH_LONG).show();
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    }
                }
            });

    }

    //inicializando variables
    private void init(){
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        edtContraseña = findViewById(R.id.edtRegisContraseña);
        edtUsuario = findViewById(R.id.edtRegisUsuario);
    }
}