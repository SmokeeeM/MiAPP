package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewDataActivity extends AppCompatActivity {

    DatabaseHelper db; // Instancia de la base de datos
    TextView dataView; // Vista para mostrar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data); // Asegúrate de que este nombre es correcto

        // Inicializar la base de datos y el TextView
        db = new DatabaseHelper(this);
        dataView = findViewById(R.id.textViewData);

        // Obtener los datos de la base de datos
        Cursor res = db.getAllData();
        if (res.getCount() == 0) {
            dataView.setText("No hay datos registrados.");
            return;
        }

        // Construir los datos en un formato legible
        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("ID: ").append(res.getString(0)).append("\n");
            buffer.append("Nombre: ").append(res.getString(1)).append("\n");
            buffer.append("Correo: ").append(res.getString(2)).append("\n");
            buffer.append("Contraseña: ").append(res.getString(3)).append("\n\n");
        }

        // Mostrar los datos en el TextView
        dataView.setText(buffer.toString());
    }
}
