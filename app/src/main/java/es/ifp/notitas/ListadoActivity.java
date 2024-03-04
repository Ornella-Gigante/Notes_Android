package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class ListadoActivity extends AppCompatActivity {


    //Declaración de variables

    private Toolbar toolbar;
    private DataBaseSQL db;
    private ListView listView;
    private ArrayList<String> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_activity);

        // Inicializar la base de datos

        db = new DataBaseSQL(this);

        // Configurar la barra de herramientas

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtener referencia al ListView

        listView = findViewById(R.id.lista1);

        // Obtener todas las notas de la base de datos

        notas = db.getAllNotas();

        // Crear un adaptador para el ListView y establecerlo

        NotasAdapter adapter = new NotasAdapter(this, notas);
        listView.setAdapter(adapter);

        // Manejar el clic en un elemento del ListView

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String tituloNota = notas.get(i);
            ArrayList<String> notaObtenida = db.getNota(tituloNota);
            if (notaObtenida != null && notaObtenida.size() >= 2) {
                String idNota = notaObtenida.get(0);
                String infoNota = notaObtenida.get(1);
                Intent intent = new Intent(ListadoActivity.this, VerNotaActivity.class);
                intent.putExtra("idNota", idNota);
                intent.putExtra("infoNota", infoNota);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Error al obtener la nota", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.crear) {

            // Abre la actividad CrearNotaActivity

            Intent intentCrear = new Intent(this, CrearNotaActivity.class);
            startActivity(intentCrear);
            return true;
        } else if (item.getItemId() == R.id.opciones) {

            // Abre la actividad BorrarNotasActivity

            Intent intentOpciones = new Intent(this, BorrarNotasActivity.class);
            startActivity(intentOpciones);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
