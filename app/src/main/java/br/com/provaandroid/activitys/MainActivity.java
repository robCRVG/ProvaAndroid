package br.com.provaandroid.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.icu.util.UniversalTimeScale;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.provaandroid.R;

public class MainActivity extends AppCompatActivity {

    private ImageView nuvemOn, nuvemOff;
    private CardView cvDadosCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaCampos();
        verificaConexao();
        navegaDadosCliente();
    }

    private void navegaDadosCliente() {
        cvDadosCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DadosCliente.class));
            }
        });
    }

    private void verificaConexao() {
        boolean on = true;
        boolean off = false;
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            nuvemOn.setVisibility(View.VISIBLE);
        } else {
            nuvemOff.setVisibility(View.VISIBLE);
        }
    }

    private void inicializaCampos() {
        nuvemOn = findViewById(R.id.ivNunvemOn);
        nuvemOn.setVisibility(View.INVISIBLE);
        nuvemOff = findViewById(R.id.ivNuvemOff);
        nuvemOff.setVisibility(View.INVISIBLE);
        cvDadosCliente = findViewById(R.id.cvDadosCliente);
    }


}