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
    Nota notaModel;
    EditText edt_titulo;
    EditText edt_nota;
    View fundo;
    boolean nova;

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
        int p = -1;

        if (extras != null) {
            p = getIntent().getExtras().getInt("position", -1);
        }
        if (p == -1) {
            notaModel = new Nota("", "", getResources().getColor(R.color.branco));
            nova = true;
        } else {
            nova = false;
            notaModel = MyData.getInstance().getNota(p);
            edt_titulo.setText(notaModel.getTitulo());
            edt_nota.setText(notaModel.getNota());
            fundo.setBackgroundColor(notaModel.getCor());
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
                } else {
                    int k = MyData.getInstance().getNotasArr().indexOf(notaModel);
                    setResult(k);
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
        notaModel.setCor(cor);
    }

    @Override
    public void onBackPressed() {
        notaModel.setTitulo(edt_titulo.getText().toString());
        notaModel.setNota(edt_nota.getText().toString());
        if (nova) {
            MyData.getInstance().insereNota(notaModel);
        }else{

            MyData.getInstance().alteraNota(notaModel);
        }
        setResult(-1);
        super.onBackPressed();
    }
}
