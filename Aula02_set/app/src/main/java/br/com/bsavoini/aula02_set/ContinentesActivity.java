package br.com.bsavoini.aula02_set;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContinentesActivity extends AppCompatActivity {
    boolean jaApertouVoltar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        setTitle("Continentes");

        SharedPreferences preferenciasDeUsuario = getSharedPreferences("dialogo", MODE_PRIVATE);
        int contador = preferenciasDeUsuario.getInt("contador", 0);
        contador++;

        if (contador <= 3) {
            preferenciasDeUsuario.edit().putInt("contador", contador).apply();
            abreDialog("Olá!", "Gostaria de nos avaliar na Google Play?");
        }

    }

    public void onClickContinente(View v) {
        Button btn = (Button) v;
        String continente = btn.getText().toString();

        Intent intent = new Intent(this, PaisesActivity.class);
        intent.putExtra("continente", continente);
        startActivity(intent);
    }

    private void abreDialog(String titulo, String mensagem) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage(mensagem)
                .setPositiveButton("Vamos lá!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        goToGooglePlay();
                    }
                })
                .setNegativeButton("Agora não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setTitle(titulo)
                .create();
        alertDialog.show();
    }

    public void goToGooglePlay() {
        final String appPackageName = "amaro.amaroandroid";
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    @Override
    public void onBackPressed() {
        if (jaApertouVoltar) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Aperte mais uma vez para sair", Toast.LENGTH_LONG).show();
            jaApertouVoltar = true;
        }

    }
}
