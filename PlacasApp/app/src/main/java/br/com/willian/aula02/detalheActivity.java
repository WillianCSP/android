package br.com.willian.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getExtras().getInt("id");
        PaisModel pais = MeusDados.getInstance().getPais(id);
        setTitle(pais.getNome());
        ImageView img_detalhe = (ImageView) findViewById(R.id.img_detalhe);
        img_detalhe.setImageResource(pais.getFotoID());
        TextView txt_sigla = (TextView) findViewById(R.id.txt_sigla);
        TextView txt_capital = (TextView) findViewById(R.id.txt_capital);

        txt_sigla.setText(pais.getSigla());
        txt_capital.setText(pais.getCapital());

        Toast.makeText(this, "id:"+id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
