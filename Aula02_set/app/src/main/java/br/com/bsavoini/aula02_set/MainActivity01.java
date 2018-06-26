package br.com.bsavoini.aula02_set;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_01);
    }

    public void onClickEntrar(View v) {
        EditText edt_usuario = (EditText) findViewById(R.id.edt_usuario);
        EditText edt_senha = (EditText) findViewById(R.id.edt_senha);

        String usuario = edt_usuario.getText().toString();
        String senha = edt_senha.getText().toString();

        boolean loginValido = login(usuario, senha);

        String msg = loginValido ? "Login com sucesso!" : "Tente novamente";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private boolean login(String usuario, String senha) {
        if (usuario.equals("anonimo") && senha.equals("123456")) {
            return true;
        }

        return false;
    }
}
