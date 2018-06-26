package br.com.bsavoini.aula02_set;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences preferenciasDeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");

        preferenciasDeUsuario = getSharedPreferences("usuario", MODE_PRIVATE);
        boolean lembrar = preferenciasDeUsuario.getBoolean("lembrar", false);

        if (lembrar) {
            abreActivity();
        } else {
            setContentView(R.layout.activity_main_login);
        }
    }

    private void abreActivity() {
        Intent intent = new Intent(this, ContinentesActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickRecuperar(View v) {
        Toast.makeText(this, "Verifique seu e-mail...", Toast.LENGTH_SHORT).show();
    }

    private void salvaLogin() {
        CheckBox chk_lembrar = (CheckBox) findViewById(R.id.chk_lembrar);
        boolean lembrar = chk_lembrar.isChecked();
        if (lembrar) {
            preferenciasDeUsuario.edit().putBoolean("lembrar", true).apply();
        }
    }


    public void onClickEntrar(View v) {
        EditText edt_usuario = (EditText) findViewById(R.id.edt_usuario);
        EditText edt_senha = (EditText) findViewById(R.id.edt_senha);

        String usuario = edt_usuario.getText().toString();
        String senha = edt_senha.getText().toString();

        boolean loginValido = login(usuario, senha);

        if (loginValido) {
            salvaLogin();
            abreActivity();
        } else {
            Toast.makeText(this, "Tente novamente!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean login(String usuario, String senha) {
        if (usuario.equals("anonimo") && senha.equals("123456")) {
            return true;
        }

        return false;
    }
}
