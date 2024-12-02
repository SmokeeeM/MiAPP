package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    DatabaseHelper db; // Clase para manejar la base de datos
    EditText name, email, password; // Campos del formulario
    Button submit, viewData, goToMain; // Botones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form); // Diseño asociado a esta actividad

        // Inicializar la base de datos
        db = new DatabaseHelper(this);

        // Asociar vistas con sus IDs
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        submit = findViewById(R.id.btnSubmit);
        viewData = findViewById(R.id.btnViewData);
        goToMain = findViewById(R.id.btnGoToMain); // Asegúrate de que este ID exista en el XML

        // Botón para guardar datos
        submit.setOnClickListener(v -> {
            String userName = name.getText().toString();
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();

            if (userName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                Toast.makeText(this, "Correo no válido", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isInserted = db.insertData(userName, userEmail, userPassword);
            if (isInserted) {
                Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para ver datos guardados
        viewData.setOnClickListener(v -> {
            Intent intent = new Intent(FormActivity.this, ViewDataActivity.class);
            startActivity(intent);
        });

        // Botón para ir a MainActivity
        goToMain.setOnClickListener(v -> {
            Intent intent = new Intent(FormActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
