package es.ifp.notitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CrearNotaActivity extends AppCompatActivity {

    //Declaración de variables
    private EditText editTextNota;
    private Button buttonCrear;
    private Button buttonVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);

        // Definición de variables
        editTextNota = findViewById(R.id.editTextNota);
        buttonCrear = findViewById(R.id.buttonCrear);
        buttonVolver = findViewById(R.id.buttonVolver);

        /**
         * El siguiente código crea un botón y le asigna una acción cuando se le cliquea.
         * Si el campo de texto está vacío, muestra un mensaje diciendo que es obligatorio. Si está lleno,
         * guarda la nota en la base de datos, muestra un mensaje de confirmación, abre la lista
         * de notas y cierra la pantalla para que no se pueda volver con el botón de "atrás".
         *
         */

        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota = editTextNota.getText().toString().trim();
                if (nota.isEmpty()) {
                    Toast.makeText(CrearNotaActivity.this, getString(R.string.obligatorio), Toast.LENGTH_SHORT).show();
                } else {
                    // Insertar nota en la base de datos
                    DataBaseSQL db = new DataBaseSQL(CrearNotaActivity.this);
                    db.insertNota(nota);
                    Toast.makeText(CrearNotaActivity.this,getString(R.string.correcto), Toast.LENGTH_SHORT).show();
                    // Ir a la actividad ListadoActivity
                    Intent intent = new Intent(CrearNotaActivity.this, ListadoActivity.class);
                    startActivity(intent);
                    finish(); // Finalizar esta actividad para evitar volver a ella con el botón "atrás"
                }
            }
        });


        /**
         * El código siguiente creará un OnClickListener para un botón llamado buttonVolver que,
         * al hacer clic en él, iniciará una nueva actividad llamada ListadoActivity y
         * finalizará la actividad actual d ela clase CrearNotaActivity.
         */

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volver a la actividad ListadoActivity
                Intent intent = new Intent(CrearNotaActivity.this, ListadoActivity.class);
                startActivity(intent);
                finish(); // Finalizar esta actividad para evitar volver a ella con el botón "atrás"
            }
        });
    }
}
