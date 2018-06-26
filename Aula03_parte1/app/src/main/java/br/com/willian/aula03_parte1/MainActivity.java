package br.com.willian.aula03_parte1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abreDialog();
    }



    private void abreDialog(){

        AlertDialog alertDialog = new AlertDialog.Builder(this).
                setMessage("Deseja avaliar a aplicação").setTitle("Avaliar").setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                irParaPlayStore();

            }
        })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this, "Cancelar", Toast.LENGTH_SHORT).show();
                    }
                }).create();
        alertDialog.show();

    }

    private void irParaPlayStore(){
        Uri uriNavegador = Uri.parse("https://play.google.com/store/apps/details?id=amaro.amaroandroid");

        Uri uriLoja = Uri.parse("market://details?id=amaro.amaroandroid");
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, uriLoja));
        }catch (Exception e){
            startActivity(new Intent(Intent.ACTION_VIEW, uriNavegador));
        }
        }
}
