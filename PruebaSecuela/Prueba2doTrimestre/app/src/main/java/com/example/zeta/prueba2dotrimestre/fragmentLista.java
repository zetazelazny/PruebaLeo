package com.example.zeta.prueba2dotrimestre;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeta on 21/8/2017.
 */

public class fragmentLista extends Fragment
{
    baseDeDatos accesoBase;
    SQLiteDatabase baseDatos;
    ArrayList<String> ArrayIngresos;
    public View onCreateView(LayoutInflater Inflador, ViewGroup Grupo, Bundle DatosRecibidos) {
        View VistaADevolver;
        VistaADevolver = Inflador.inflate(R.layout.fragment_lista, Grupo, false);
        ListView ListaIngresos = (ListView)VistaADevolver.findViewById(R.id.ListaIngresos);
        ArrayIngresos = traerIngresos();
        Adapter Adaptador;
        Adaptador = new Adapter(ArrayIngresos, getContext());
        ListaIngresos.setAdapter(Adaptador);
        return VistaADevolver;
    }

    public ArrayList<String> traerIngresos()
    {
        ArrayList<String> Ingresos = new ArrayList<String>();
        if (baseDeDatosAbierta())
        {
            Cursor CursorDeRegistros;
            CursorDeRegistros = baseDatos.rawQuery("select * FROM ingresos", null);
            if (CursorDeRegistros.moveToFirst())
            {
                while(CursorDeRegistros.moveToNext())
                {
                    String Ingreso = CursorDeRegistros.getString(0);
                    Ingresos.add(Ingreso);
                }
            }
            baseDatos.close();
    }
    return Ingresos;
}
    Boolean baseDeDatosAbierta()
    {
        Boolean Respuesta = false;
        accesoBase = new baseDeDatos(getContext(), "baseDeDatos", null, 1);
        baseDatos = accesoBase.getWritableDatabase();
        if (baseDatos != null)
        {
            Respuesta = true;
        }
        return Respuesta;
    }

}
