package com.jherrera.menutap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuienSoyFragment extends Fragment {

    private Button buttonEnviarMensaje;

    public QuienSoyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quien_soy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitComponents(view);
    }

    private void setInitComponents(View view) {
        buttonEnviarMensaje = view.findViewById(R.id.buttonEnviarMensaje);

        buttonEnviarMensaje.setOnClickListener(v -> {
            String telefono = "+50377288054";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String mensaje = "Hola Isai!: ";
            String uri = "whatsapp://send?phone=" + telefono + "&text="+mensaje;
            intent.setData(Uri.parse(uri));
            startActivity(intent);
        });
    }
}