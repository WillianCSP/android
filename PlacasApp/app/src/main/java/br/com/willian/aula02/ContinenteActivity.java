package br.com.willian.aula02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContinenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continente);
        setTitle("Continentes");
    }

    public void onClickContinente(View v){

        Button btn= (Button) v;
        Intent intent  =new Intent(this,PaisesActivity.class);
        intent.putExtra("continente",btn.getText());
        startActivity(intent);
    }
}
