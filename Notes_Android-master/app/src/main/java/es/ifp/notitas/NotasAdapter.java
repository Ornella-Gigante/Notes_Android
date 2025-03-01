package es.ifp.notitas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * En esta clase llamada @NotasAdapter ese crea un adaptador personalizado que extiende la clase ArrayAdapter y se utiliza para mostrar
 * una lista de notas en una interfaz de usuario. El adaptador se encarga de inflar la vista de cada elemento de la lista y
 * asignar el texto correspondiente a cada elemento de la lista de notas. Se utiliza en conjunto con una lista de notas
 * (ArrayList<String>) y un contexto (Context) para poder mostrar las notas en la interfaz de usuario.
 * @author Ornella Gigante
 *
 */
public class NotasAdapter extends ArrayAdapter<String> {
    public NotasAdapter(Context context, ArrayList<String> notas) {
        super(context, 0, notas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Se verificará si la vista actual está siendo reutilizada, de lo contrario se va a inflar
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        // Obtener el elemento de la lista en la posición actual
        String nota = getItem(position);

        // Buscar el TextView en la vista inflada
        TextView textViewNota = convertView.findViewById(android.R.id.text1);

        // Establecer el texto de la nota en el TextView
        textViewNota.setText(nota);

        // Devolver la vista configurada
        return convertView;
    }
}

