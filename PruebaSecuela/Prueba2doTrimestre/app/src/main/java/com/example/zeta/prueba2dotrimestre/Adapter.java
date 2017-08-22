package com.example.zeta.prueba2dotrimestre;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeta on 21/8/2017.
 */

public class Adapter extends BaseAdapter
{
    private ArrayList<String> _ListaIngresos;
    private Context _MiContexto;

    public Adapter (ArrayList<String> ListaRecibida, Context ContextoRecibido)
    {
        _ListaIngresos = ListaRecibida;
        _MiContexto = ContextoRecibido;
        Log.d("Adapter declarado", "Lista: "+_ListaIngresos.size() + " contexto: " + _MiContexto);
    }

    public int getCount()
    {
        return _ListaIngresos.size();
    }

    public String getItem(int Posicion)
    {
        String IngresoObtener;
        IngresoObtener = _ListaIngresos.get(Posicion);
        return IngresoObtener;
    }

    public long getItemId(int Posicion)
    {
        return Posicion;
    }

    public View getView(int PosicionActual, View view, ViewGroup viewGroup) {
        View VistaaDevolver;
        LayoutInflater inflater;
        inflater = (LayoutInflater)_MiContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaaDevolver = inflater.inflate(R.layout.detalle_ingreso, viewGroup, false);
        TextView Titulo = (TextView)VistaaDevolver.findViewById(R.id.TextIngreso);
        String TextoposicionActual = getItem(PosicionActual);
        Titulo.setText(TextoposicionActual);
        return VistaaDevolver;
    }
}
