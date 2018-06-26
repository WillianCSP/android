package br.com.willian.aula3_parte2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class  BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_v2, menu);

//        MenuItem item_email = menu.findItem(R.id.item_email);
//        item_email.setIcon(R.drawable.ic_phone);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        String titulo = item.getTitle().toString();
//        Toast.makeText(this, titulo, Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {

            case R.id.email_marketing:
                this.abrirEmail("mkt@aaa.com");
                break;
            case R.id.email_sac:
                this.abrirEmail("sac@aaa.com");
                break;
            case R.id.telefone_marketing:
                this.abrirTelefone("11987966003");
                break;
            case R.id.telefone_sac:
                this.abrirTelefone("19 999991234");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void abrirEmail(String destinatario) {
//        Toast.makeText(this, "Email para: "+destinatario, Toast.LENGTH_SHORT).show();
        try {


            Intent email_intent = new Intent(Intent.ACTION_SENDTO);
            email_intent.setData(Uri.parse("mailto:"));
            email_intent.putExtra(Intent.EXTRA_EMAIL, new String[]{destinatario});
            email_intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo App");

            startActivity(email_intent);

        } catch (Exception e) {

            Toast.makeText(this, "Descuple não foi possível iniciar o email", Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirTelefone(String numeroDoTelefone) {
//        Toast.makeText(this, "Telefone para: "+numeroDoTelefone, Toast.LENGTH_SHORT).show();

        try {


            Intent telefone_intent = new Intent(Intent.ACTION_DIAL);
            telefone_intent.setData(Uri.parse("tel:" + numeroDoTelefone));
            startActivity(telefone_intent);

        } catch (Exception e) {

            Toast.makeText(this, "Descuple não foi possível iniciar o telefone", Toast.LENGTH_SHORT).show();
        }
    }
}
