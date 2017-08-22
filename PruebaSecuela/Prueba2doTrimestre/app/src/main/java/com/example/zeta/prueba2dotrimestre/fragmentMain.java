package com.example.zeta.prueba2dotrimestre;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

/**
 * Created by Zeta on 21/8/2017.
 */

public class fragmentMain extends Fragment implements View.OnClickListener {
    EditText IngresoDeTexto;
    public View onCreateView(LayoutInflater Inflador, ViewGroup Grupo, Bundle DatosRecibidos) {
        View VistaADevolver;
        VistaADevolver = Inflador.inflate(R.layout.fragment_main, Grupo, false);
        IngresoDeTexto = (EditText) VistaADevolver.findViewById(R.id.IngresoDeDatos);
        Button BotonAñadir = (Button) VistaADevolver.findViewById(R.id.BotonAñadir);
        Button BotonBuscar = (Button) VistaADevolver.findViewById(R.id.BotonBuscar);
        Button BotonBorrar = (Button) VistaADevolver.findViewById(R.id.BotonBorrar);
        Button BotonListar = (Button) VistaADevolver.findViewById(R.id.BotonALista);
        BotonAñadir.setOnClickListener(this);
        BotonBuscar.setOnClickListener(this);
        BotonBorrar.setOnClickListener(this);
        BotonListar.setOnClickListener(this);
        return VistaADevolver;
    }

    public void onClick (View Vista)
    {
        String Texto = IngresoDeTexto.getText().toString();
        Button Boton = (Button)Vista;
        String Tag = String.valueOf(Boton.getTag());
        ActivityPrincipal Activity;
        Activity = (ActivityPrincipal)getActivity();
        Log.d("Bug 1", "Tag vale: " + Tag);
        switch (Tag)
        {
            case "Añadir":

                Activity.Añadir(Texto);
                break;

            case "Buscar":
                Log.d("Bug 1", Texto);
                    Activity.Buscar(Texto);
                    Log.d("Bug 1", "Entra a buscar");
                break;

            case "Borrar":
                Activity.Borrar(Texto);
                break;

            case "Listar":
                Activity.aFrgLista();
                break;
            }

        }
    }

