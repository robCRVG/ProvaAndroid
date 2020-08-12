package br.com.provaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.util.UniversalTimeScale;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView nuvemOn, nuvemOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaCampos();
        verificaConexao();
    }

    private void inicializaCampos(){
        nuvemOn = findViewById(R.id.ivNunvemOn);
        nuvemOn.setVisibility(View.INVISIBLE);
        nuvemOff = findViewById(R.id.ivNuvemOff);
        nuvemOff.setVisibility(View.INVISIBLE);
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
        }else{
            nuvemOff.setVisibility(View.VISIBLE);
        }
    }
}