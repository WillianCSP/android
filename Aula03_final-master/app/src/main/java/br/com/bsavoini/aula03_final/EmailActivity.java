package br.com.bsavoini.aula03_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getExtras().getInt("id");

        EmailModel emailModel  = MyData.getInstance().getEmailModel(id);
        TextView txt_remetente = (TextView) findViewById(R.id.txt_remetente);
        txt_remetente.setText(emailModel.getRemetente());

        TextView txt_assunto = (TextView) findViewById(R.id.txt_assunto);
        txt_assunto.setText(emailModel.getAssunto());

        TextView txt_mensagem = (TextView) findViewById(R.id.txt_mensagem);
        txt_mensagem.setText(emailModel.getMensagem());


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){

            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
