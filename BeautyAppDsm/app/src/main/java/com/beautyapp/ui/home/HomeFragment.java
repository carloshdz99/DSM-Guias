package com.beautyapp.ui.home;

import android.app.DatePickerDialog;
import android.os.Bundle;
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

import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
<<<<<<< HEAD
    private ListView lista;
    private TextView servicio, precio, date;
    private Button btnfecha;
    private int dia, mes, anio;
=======
>>>>>>> 234d7161aee18c45db65402b0dd1d684dfc55231

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        servicio = root.findViewById(R.id.txtservicio);
        precio = root.findViewById(R.id.txtprecio);

        //root es la variable que es tomando la vista y todos sus elementos
<<<<<<< HEAD
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
=======
>>>>>>> 234d7161aee18c45db65402b0dd1d684dfc55231

        date = root.findViewById(R.id.fecha);
        btnfecha = root.findViewById(R.id.btnfecha);

        btnfecha.setOnClickListener(this);

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
}