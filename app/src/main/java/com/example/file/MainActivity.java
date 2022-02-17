package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    Button btnLeggi;
Button btnScrivi;
    TextView txtContenuto;
    GestoreFile gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeggi=(Button)findViewById(R.id.btnLeggi);
        btnScrivi=(Button)findViewById(R.id.btnScrivi);
        txtContenuto=(TextView)findViewById(R.id.textContenuto);
        gf=new GestoreFile();
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringaRicevuta=gf.readFile("Filedaleggere.txt", getApplicationContext());

                Toast.makeText(getApplicationContext(),stringaRicevuta, Toast.LENGTH_SHORT).show();
                txtContenuto.setText(stringaRicevuta);
            }
        });

        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito=gf.scriviFile("Filedaleggere.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(),esito, Toast.LENGTH_SHORT).show();
                txtContenuto.setText(esito);
            }
        });
    }
}