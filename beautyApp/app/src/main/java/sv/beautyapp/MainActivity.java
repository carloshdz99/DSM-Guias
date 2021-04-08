package sv.beautyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //cambiando estilo de tema despues de cargada la aplicacion
        setTheme(R.style.Theme_BeautyApp);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ocultando la actionbar
        getSupportActionBar().hide();
    }
}