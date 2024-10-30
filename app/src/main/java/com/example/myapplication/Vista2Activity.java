package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Vista2Activity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_vista2);

                // Botón para navegar a Vista3Activity (Chimpancé)
                Button buttonToVista3 = findViewById(R.id.buttonToVista3);
                buttonToVista3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Navegar a Vista3Activity (Chimpancé)
                                Intent intent = new Intent(Vista2Activity.this, Vista3Activity.class);
                                startActivity(intent);
                        }
                });

                // Botón de retroceso a MainActivity (Vista 1)
                Button backToMain = findViewById(R.id.backButtonToMain);
                backToMain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Navegar a MainActivity (Vista 1)
                                Intent intent = new Intent(Vista2Activity.this, MainActivity.class);
                                startActivity(intent);
                        }
                });
        }
}
