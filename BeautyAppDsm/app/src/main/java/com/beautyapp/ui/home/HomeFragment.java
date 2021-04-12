package com.beautyapp.ui.home;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.beautyapp.MainActivity;
import com.beautyapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private HomeViewModel homeViewModel;
    private ListView lista;
    private TextView servicio, precio, date;
    private Button btnfecha, btnCita;
    private int dia, mes, anio;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        servicio = root.findViewById(R.id.txtservicio);
        precio = root.findViewById(R.id.txtprecio);
        date = root.findViewById(R.id.fecha);

        //root es la variable que es tomando la vista y todos sus elementos
        lista = root.findViewById(R.id.list);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getContext(),
                R.array.arrayTratamientos,
                android.R.layout.simple_list_item_1);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("50");
                        break;
                    case 1:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$46");
                        break;
                    case 2:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$257");
                        break;
                    case 3:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$85");
                        break;
                    case 4:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$28");
                        break;
                    case 5:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$35");
                        break;
                    case 6:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$20");
                        break;
                    case 7:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$24");
                        break;
                    case 8:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$49");
                        break;
                    case 9:
                        servicio.setText(parent.getItemAtPosition(position).toString());
                        precio.setText("$48");
                        break;
                }
            }
        });

        date = root.findViewById(R.id.fecha);
        btnfecha = root.findViewById(R.id.btnfecha);

        btnfecha.setOnClickListener(this);
        btnCita = root.findViewById(R.id.btnCita);
        btnCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Agendar();
            }
        });

        return root;

    }


    @Override
    public void onClick(View v) {
        if(v==btnfecha){
            final Calendar c = Calendar.getInstance();

            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    date.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                }
            }, dia, mes, anio);
            datePickerDialog.show();
        }


    }

    public void Agendar(){
               mAuth = FirebaseAuth.getInstance();
               FirebaseFirestore db = FirebaseFirestore.getInstance();

               String ser = servicio.getText().toString();
               String pre = precio.getText().toString();
               String fec = date.getText().toString();
               String us = mAuth.getCurrentUser().getEmail().toString();

        Map<String, Object> cita = new HashMap<>();
        cita.put("Correo", us);
        cita.put("Servicio", ser);
        cita.put("Precio", pre);
        cita.put("Fecha", fec);

        db.collection("Citas").document()
                .set(cita)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                        Toast toast = Toast.makeText(getContext(), "Registro exitoso" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });

      /*  db.collection("Citas")
                .add(cita)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });*/
    }
}