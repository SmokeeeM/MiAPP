package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón para navegar a MainActivity (Vista 1)
        Button buttonToMain = findViewById(R.id.infoButton2);
        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega a MainActivity (Vista 1)
                Intent intent = new Intent(MainActivity.this, Vista2Activity.class);
                startActivity(intent);
            }
        });
    }
}
