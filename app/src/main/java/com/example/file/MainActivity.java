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
    TextView txtOut;
    GestoreFile gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeggi=(Button)findViewById(R.id.btnLeggi);
        btnScrivi=(Button)findViewById(R.id.btnScrivi);
        txtContenuto=(TextView)findViewById(R.id.textContenuto);
        txtOut=(TextView)findViewById(R.id.textView);
        gf=new GestoreFile();
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String stringaRicevuta=gf.readFile(txtContenuto.getText().toString(), getApplicationContext());
                String stringaRicevuta=gf.leggiAsset(getApplicationContext());
                Toast.makeText(getApplicationContext(),stringaRicevuta, Toast.LENGTH_SHORT).show();
                txtOut.setText(stringaRicevuta);
            }
        });

        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito=gf.scriviFile(txtContenuto.getText().toString(), getApplicationContext());
                Toast.makeText(getApplicationContext(),esito, Toast.LENGTH_SHORT).show();
                txtOut.setText(esito);
            }
        });
    }
}