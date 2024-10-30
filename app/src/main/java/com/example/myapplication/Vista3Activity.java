package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Vista3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista3);

        // Botón de retroceso a Vista2Activity
        Button backToVista2 = findViewById(R.id.backButtonToVista2);
        backToVista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a Vista2Activity
                Intent intent = new Intent(Vista3Activity.this, Vista2Activity.class);
                startActivity(intent);
            }
        });
    }
}
