package com.example.zeta.prueba2dotrimestre;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zeta on 21/8/2017.
 */

public class baseDeDatos extends SQLiteOpenHelper
{
    public baseDeDatos(Context Contexto, String Nombre, SQLiteDatabase.CursorFactory Fabrica, int Version)
    {
        super(Contexto, Nombre, Fabrica, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos)
    {
        String sqlCrearTablaIngresos;
        sqlCrearTablaIngresos = "create table ingresos (ingreso text)";
        baseDeDatos.execSQL(sqlCrearTablaIngresos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int versionAnterior, int versionNueva)
    {

    }
}
