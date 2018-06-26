package br.com.willian.aula01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario u = new Usuario("Bruno");
        u.informaAno(1989);
        u.login();
        u.logout();
        this.mostraLog(u.getDados());

        Usuario u2 = new Usuario("Will");
        u2.login();
        mostraLog(u2.getDados());

        Usuario usuarios[] = new Usuario[4];
        usuarios[0] = new Usuario("Bruno");
        usuarios[0] = new Usuario("Gustavo");
        usuarios[0] = new Usuario("Priscila");
        usuarios[0] = new Usuario("Renan");
//        int idades[] = new int[4];
//        idades[0] = 25;
//        idades[1] = 18;
//        idades[2] = 23;
//        idades[3] = 28;

        for(int i=0; i<4;i++){

            mostraLog("Idade"+i+": "+usuarios[i].nome);
        }
//        mostraLog("Idade0: "+idades[0]);
//        mostraLog("Idade1: "+idades[1]);
//        mostraLog("Idade2: "+idades[2]);
//        mostraLog("Idade3: "+idades[3]);




        ArrayList<Usuario> usuarioArrayList = new ArrayList<>();
        usuarioArrayList.add(new Usuario("Leandro"));
        usuarioArrayList.add(new Usuario("Fernando"));
        usuarioArrayList.add(new Usuario("Wiliam"));
        usuarioArrayList.add(new Usuario("Sergio"));
        usuarioArrayList.add(new Usuario("Esdras"));

       
    }






    private void mostraLog(String msg){
        Log.d("svn",msg);
    }
}
