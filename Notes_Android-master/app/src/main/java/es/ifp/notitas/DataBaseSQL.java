package es.ifp.notitas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {

    //Declaración de variables

    private static final String DATABASE_NAME = "notitas.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla 'notas' con las columnas 'id' y 'nota'

        db.execSQL("CREATE TABLE notas (id INTEGER PRIMARY KEY AUTOINCREMENT, nota TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí se manejará la actualización de la BBDD como se vea necesario
    }

    //Método que insertará notas
    public void insertNota(String nota) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO notas (nota) VALUES (?)", new Object[]{nota});
        db.close();
    }

    //Método que borrará notas

    public void deleteNota(String titulo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas WHERE nota = ?", new String[]{titulo});
        db.close();
    }

    //Método que mostrará todas las notas en el ListView
    public ArrayList<String> getAllNotas() {
        ArrayList<String> notas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nota FROM notas", null);
        if (cursor.moveToFirst()) {
            do {
                notas.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notas;
    }

    // Método para ver las notas por separado al hacer longClick
    public ArrayList<String> getNota(String titulo) {
        ArrayList<String> nota = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nota FROM notas WHERE nota = ?", new String[]{titulo});
        if (cursor.moveToFirst()) {
            nota.add(cursor.getString(0)); // Id de la nota
            nota.add(cursor.getString(1)); // Información de la nota
        }
        cursor.close();
        db.close();
        return nota;
    }


    // Método que borra todas las notas
    public void deleteAllNotas() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas");
        db.close();
    }
}

