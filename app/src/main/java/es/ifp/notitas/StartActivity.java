package es.ifp.notitas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import es.ifp.notitas.R;

/**
 * RESUMEN DEL PROYECTO Y SU FUNCIONAMIENTO:
 * En este proyecto, se creará un gestor de notas simple con recordatorio de tareas mediante Java.
 * El proyecto constará de varias clases, cada una con diferentes tareas:
 * @ListadoActivity, donde se verá el listado de tareas
 * @CrearNotaActivity, donde se crearán las notas que luego se verá en ListadoActivity
 * @BorrarNotaActivity donde se borrarán las notas (sea una o en su totalidad)
 * @VerNotaActivity donde se leerán las notas creadas en @CrearNotaActivity
 * @DataBaseSQL que contendrá la base de datos basada en SQLite con la estructura de la tabla
 * @StartActivity que será la cara primera del arranque de la aplicación, mostrará el nombre de la BBDD
 * y tras 2 segundos de inactividad se pasará a otro layout que muestre la lista de notas
 * @NotasAdapter que creará un adaptador personalizado que para la lista de notas de @ListadoActivity
 * y mostrará el texto de la nota de un TexView
 * El proyecto constará también de varios layouts:
 * activity_borrar_notas.xml---->define posición y apariencia de @BorrarNotasActivity
 * activity_crear_notas.xml----->define posición y apariencia de @CrearNotaActivity
 * activity_ver_nota.xml   ----->define posición y apariencia de @VerNotaActivity
 * app_bar_listado.xml     ----->define posición y apariencia de la barra de opciones del menú
 * listado_activity.xml    ----->define posición y apariencia de @ListadoActivity
 * menu_listado.xml        ----->contiene los items Crear y Opciones de la clase @ListadoActivity
 * @author Ornella Gigante
 */

public class StartActivity extends AppCompatActivity {

    //Declaración de variables (con los segundos de espera deseados=2)
    private static final int SEGUNDOS_ESPERA = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this,ListadoActivity.class);
                startActivity(intent);

            }
        }, SEGUNDOS_ESPERA * 2000); // Convertir segundos a milisegundos
    }
}
