package com.jherrera.menutap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TecnologiasFragment extends Fragment {

    private Button buttonEnviarCorreo;

    public TecnologiasFragment() {
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
        return inflater.inflate(R.layout.fragment_tecnologias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitComponents(view);
    }

    private void setInitComponents(View view) {
        buttonEnviarCorreo = view.findViewById(R.id.buttonEnviarCorreo);

        buttonEnviarCorreo.setOnClickListener(v -> {
            sendEmail(view.getContext());
        });
    }

    //envia un mensaje por correo electronico
    private void sendEmail(Context context) {
        String[] TO = {"herrera_jh17@outlook.com"}; //Direcciones email  a enviar.
        String[] CC = {"u20190846@univo.edu.sv"}; //Direcciones email con copia.

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Me interesa tus servicios");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola! Josué Isaí Herrera Benítez "); // * configurar email aquí!

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email."));
            Log.i("EMAIL", "Enviando email...");
        }
        catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(context, "NO existe ningún cliente de email instalado!.", Toast.LENGTH_SHORT).show();
        }
    }
}