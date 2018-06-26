package br.com.bsavoini.blocodenotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import br.com.bsavoini.blocodenotas.bancodedados.Nota;

public class NotaActivity extends AppCompatActivity {
    EditText edt_titulo;
    EditText edt_nota;
    View fundo;
    boolean nova;
    Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_titulo = (EditText) findViewById(R.id.edt_titulo);
        edt_nota = (EditText) findViewById(R.id.edt_nota);
        fundo = findViewById(R.id.fundo);

        Bundle extras = getIntent().getExtras();

        int p = getIntent().getExtras().getInt("position", -1);

        if (p >= 0) {
            nota = MyData.getInstance().getNota(p);
            edt_nota.setText(nota.getNota());
            edt_titulo.setText(nota.getTitulo());
            setCor(nota.getCor());
            nova=false;
        }else{
            nova=true;
            nota = new Nota("","",getResources().getColor(R.color.branco));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notas_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_apagar:
                if (nova) {
                    setResult(-2);
                }else{

                    int posicao = MyData.getInstance().getNotasArr().indexOf(nota);
                    setResult(posicao);
                }
                finish();
                break;

            case R.id.item_amarelo:
                setCor(getResources().getColor(R.color.amarelo));
                break;

            case R.id.item_branco:
                setCor(getResources().getColor(R.color.branco));
                break;

            case R.id.item_verde:
                setCor(getResources().getColor(R.color.verde));
                break;

            case R.id.item_azul:
                setCor(getResources().getColor(R.color.azul));
                break;

            case R.id.item_laranja:
                setCor(getResources().getColor(R.color.laranja));
                break;

            default:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setCor(int cor) {
        fundo.setBackgroundColor(cor);
        nota.setCor(cor);
    }

    @Override
    public void onBackPressed() {
        nota.setTitulo(edt_titulo.getText().toString());
        nota.setNota(edt_nota.getText().toString());
        if(nova){
            MyData.getInstance().insereNota(nota);
        }
        setResult(-1);
        super.onBackPressed();

    }
}
