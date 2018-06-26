package br.com.bsavoini.aula02_set;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getExtras().getInt("id", 0);
        PaisModel paisModel = MeusDados.getInstance().getPais(id);

        setTitle(paisModel.getNome());

        TextView txt_capital = (TextView) findViewById(R.id.capital);
        txt_capital.setText(paisModel.getCapital());

        TextView txt_sigla = (TextView) findViewById(R.id.sigla);
        txt_sigla.setText(paisModel.getSigla());

        ImageView img_foto = (ImageView) findViewById(R.id.img);
        img_foto.setImageResource(paisModel.getFotoID());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
