package com.example.quantidadevezes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textViewAcessos;
    Button buttonFechar;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAcessos = findViewById(R.id.textViewAcessos);
        buttonFechar = findViewById(R.id.buttonFechar);

        sharedPreferences = getSharedPreferences("bdAcesso", Context.MODE_PRIVATE);

        int acessos = sharedPreferences.getInt("acessos", 0);
        acessos = acessos + 1;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("acessos", acessos);
        editor.apply();

        textViewAcessos.setText("Acessos: " + String.valueOf(acessos));

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}