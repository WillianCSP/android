package br.com.bsavoini.aula02_set;

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
        img_pais1.setImageResource(paises.get(0).getBandeiraID());

        ImageView img_pais2 = (ImageView) findViewById(R.id.img_pais2);
        img_pais2.setImageResource(paises.get(1).getBandeiraID());

        ImageView img_pais3 = (ImageView) findViewById(R.id.img_pais3);
        img_pais3.setImageResource(paises.get(2).getBandeiraID());
    }

    public void onClickPais(View v) {
        int id = 0;
        switch (v.getId()) {
            case R.id.img_pais1:
                id = paises.get(0).getId();
                break;

            case R.id.img_pais2:
                id = paises.get(1).getId();
                break;
            case R.id.img_pais3:
                id = paises.get(2).getId();
                break;
        }

        Intent intent = new Intent(this, DetalheActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
