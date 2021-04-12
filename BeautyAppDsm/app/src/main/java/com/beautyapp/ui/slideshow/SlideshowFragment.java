package com.beautyapp.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.beautyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    private ListView listView, listViewfechas;
    private ArrayList<String> arrayList, arrayListfecha;
    private ArrayAdapter<String> arrayAdapter, arrayAdapterfechas;

    private FirebaseAuth mAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        //tomando lista
        arrayList = new ArrayList<String>();
        arrayListfecha = new ArrayList<String>();

        //instanciando firebase
        mAuth = FirebaseAuth.getInstance();

        //tomando la listview
        listView = root.findViewById(R.id.ltsCitas);
        listViewfechas = root.findViewById(R.id.ltsFechas);

        //adaptador de arreglo
       // arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);

        getCitas();
        //pasando datos a la listview
        //listView.setAdapter(arrayAdapter);


        return root;
    }


    private void getCitas(){
        //.whereEqualTo("Correo", userEmail)
        FirebaseUser user = mAuth.getCurrentUser();
        String userEmail = user.getEmail();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //tomando las citas
        db.collection("Citas").whereEqualTo("Correo", userEmail)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    private static final String TAG ="firestore" ;

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                Log.d(TAG, document.getId() + " => " + document.getData().get("Servicio"));
                                arrayList.add(document.getData().get("Servicio").toString());
                                arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);
                                listView.setAdapter(arrayAdapter);

                                arrayListfecha.add(document.getData().get("Fecha").toString());
                                arrayAdapterfechas = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayListfecha);
                                listViewfechas.setAdapter(arrayAdapterfechas);
                            }
                        }else {
                            Log.w(TAG, "error al llamar los datos ", task.getException());
                        }
                    }
                });
    }
}