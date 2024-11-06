package com.example.mudacor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean ehPreto = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botao = findViewById(R.id.botaoMudaCor);
        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "Mudou de cor!", Toast.LENGTH_SHORT).show();
                if(ehPreto){
                    findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                }
                else{
                    findViewById(R.id.main).setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                }
                ehPreto = !ehPreto;

            }
        });
    }
}