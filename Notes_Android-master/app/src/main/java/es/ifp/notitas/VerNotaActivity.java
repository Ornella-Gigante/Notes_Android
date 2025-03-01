package es.ifp.notitas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class VerNotaActivity extends AppCompatActivity {

    //Declaración de variables

    private String idNota;
    private String infoNota;
    private DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_nota);

        // Se obtendrá la información de la nota del Intent
        Intent intent = getIntent();
        idNota = intent.getStringExtra("idNota");
        infoNota = intent.getStringExtra("infoNota");

        // Se mostrará la información de la nota en los TextView correspondientes

        TextView textViewId = findViewById(R.id.textViewId);
        TextView textViewInfo = findViewById(R.id.textViewInfo);

        textViewId.setText(getString(R.string.id_nota) + idNota);
        textViewInfo.setText(getString(R.string.info_nota) + infoNota);

        // Acá se inicializa la instancia de la BBDD

        db = new DataBaseSQL(this);

        // Botón para borrar la nota
        Button btnBorrar = findViewById(R.id.borrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se mostrará un cuadro de diálogo de confirmación
                AlertDialog.Builder builder = new AlertDialog.Builder(VerNotaActivity.this);
                builder.setMessage(getString(R.string.seguro))
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Borra la nota si el usuario confirma
                                db.deleteNota(infoNota); // Corregir aquí para pasar el título de la nota
                                Toast.makeText(VerNotaActivity.this, getString(R.string.borrado), Toast.LENGTH_SHORT).show();
                                // Vuelve a ListadoActivity
                                Intent intent = new Intent(VerNotaActivity.this, ListadoActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // No hacer nada si el usuario cancela
                                Toast.makeText(VerNotaActivity.this, getString(R.string.no_borrado), Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                // Mostrar el cuadro de diálogo
                builder.create().show();
            }
        });

        // Botón para volver
        Button btnVolver = findViewById(R.id.buttonVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se vuelve a ListadoActivity
                Intent intent = new Intent(VerNotaActivity.this, ListadoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}