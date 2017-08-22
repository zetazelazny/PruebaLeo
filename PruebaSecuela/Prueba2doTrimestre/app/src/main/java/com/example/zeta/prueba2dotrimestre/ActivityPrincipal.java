package com.example.zeta.prueba2dotrimestre;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityPrincipal extends AppCompatActivity {
    FragmentManager AdminDeFrags;
    FragmentTransaction TransaDeFrags;
    baseDeDatos accesoBase;
    SQLiteDatabase baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        AdminDeFrags = getSupportFragmentManager();
        Fragment frgMain;
        frgMain = new fragmentMain();
        TransaDeFrags = AdminDeFrags.beginTransaction();
        TransaDeFrags.replace(R.id.Alojador, frgMain);
        TransaDeFrags.commit();
    }

    public void Añadir(String TextoAIngresar)
    {
        if (baseDeDatosAbierta())
        {
            ContentValues nuevoRegistro;
            nuevoRegistro = new ContentValues();
            nuevoRegistro.put("ingreso", TextoAIngresar);
            baseDatos.insert("ingresos", null, nuevoRegistro);
            baseDatos.close();
            Toast.makeText(this, "Ingreso completado", Toast.LENGTH_SHORT).show();
        }
    }

    public void Buscar(String TextoABuscar)
    {
        Boolean Respuesta = false;
        if (baseDeDatosAbierta())
        {
            String Consulta = "select * from ingresos where ingreso='"+TextoABuscar.trim()+"'";
            Cursor CursorDeRegistros;
            CursorDeRegistros = baseDatos.rawQuery(Consulta, null);
            if (CursorDeRegistros.moveToFirst())
            {
                Respuesta = true;
            }
            baseDatos.close();
        }

        if (Respuesta)
        {
            Toast.makeText(this, "Ingreso encontrado", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Ingreso no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void Borrar(String TextoABorrar)
    {
        if (baseDeDatosAbierta())
        {
            baseDatos.delete("ingresos","where ingreso=" + TextoABorrar + "", null);
            baseDatos.close();
            Toast.makeText(this, "Ingreso borrado exitosamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void aFrgLista()
    {
        AdminDeFrags = getSupportFragmentManager();
        Fragment frgLista;
        frgLista = new fragmentLista();
        TransaDeFrags = AdminDeFrags.beginTransaction();
        TransaDeFrags.replace(R.id.Alojador, frgLista);
        TransaDeFrags.commit();
    }

    Boolean baseDeDatosAbierta()
    {
        Boolean Respuesta = false;
        accesoBase = new baseDeDatos(this, "ingresos", null, 1);
        baseDatos = accesoBase.getWritableDatabase();
        if (baseDatos != null)
        {
            Respuesta = true;
        }
        return Respuesta;
    }
}
