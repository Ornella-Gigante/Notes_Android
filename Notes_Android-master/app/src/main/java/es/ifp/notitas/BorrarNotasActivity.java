package es.ifp.notitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BorrarNotasActivity extends AppCompatActivity {


    //Definición de variables

    private Button borrar;
    private Button buttonVolver;
    private DataBaseSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_notas);

        // Se definen las variables

        db = new DataBaseSQL(this); // Se inciializa la BBDD
        borrar = findViewById(R.id.borrar1);
        buttonVolver = findViewById(R.id.buttonVolver); // Se inicializa el botón VOLVER


        /**
         *   El primer botón se encarga de borrar todas las notas de la base de datos, mostrar un mensaje
         *   de confirmación mediante un Toast y luego redireccionar al usuario a la actividad ListadoActivity.
         */

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Borrar todas las notas de la base de datos
                db.deleteAllNotas();
                Toast.makeText(BorrarNotasActivity.this, R.string.se_ha_borrado, Toast.LENGTH_SHORT).show();
                // Ir a la actividad ListadoActivity
                Intent intent = new Intent(BorrarNotasActivity.this, ListadoActivity.class);
                startActivity(intent);
                finish(); // Finalizar esta actividad para evitar volver a ella con el botón "atrás"
            }
        });

        /**
         * El siguiennte botón redirecciona al usuario a la actividad ListadoActivity sin realizar ninguna acción adicional.
         */

        // Agregar listener al botón Volver para regresar a ListadoActivity

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a la actividad ListadoActivity
                Intent intent = new Intent(BorrarNotasActivity.this, ListadoActivity.class);
                startActivity(intent);
                finish(); // Finalizar esta actividad para evitar volver a ella con el botón "atrás"
            }
        });
    }
}
