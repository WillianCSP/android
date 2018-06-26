package br.com.willian.aula02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class PaisesActivity extends AppCompatActivity {

    ArrayList<PaisModel> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String continente = getIntent().getExtras().getString("continente");
        setTitle(continente);
        paises = MeusDados.getInstance().getPaisesArr(continente);

        ImageView img_pais1 = (ImageView) findViewById(R.id.img_pais1);
        ImageView img_pais2 = (ImageView) findViewById(R.id.img_pais2);
        ImageView img_pais3 = (ImageView) findViewById(R.id.img_pais3);

        img_pais1.setImageResource(paises.get(0).getBandeiraID());
        img_pais2.setImageResource(paises.get(1).getBandeiraID());
        img_pais3.setImageResource(paises.get(2).getBandeiraID());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickPais(View v){
        int posicao = 0;
        switch(v.getId()){

            case R.id.img_pais1:
                posicao=0;
                break;
            case R.id.img_pais2:
                posicao=1;
                break;
            case R.id.img_pais3:
                posicao=2;
                break;

        }
        int id =paises.get(posicao).getId();

        Intent intent = new Intent(this, detalheActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
