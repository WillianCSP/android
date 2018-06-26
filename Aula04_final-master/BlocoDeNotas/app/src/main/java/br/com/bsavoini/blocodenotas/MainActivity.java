package br.com.bsavoini.blocodenotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import br.com.bsavoini.blocodenotas.interfaces.BancoDeDadosCallBack;
import br.com.bsavoini.blocodenotas.interfaces.ItemClick;

/**
 * * -----------------------------------------------------
 * Aula 04
 * 1- Importar libs no build.gradle (app) e maven (project)
 * 2- Aplicar annotations no Model
 * 3- Criar NotaDAO
 * -----------------------------------------------------
 * -----------------------------------------------------
 * Aula 05
 * 1- Criar BancoDeDados.java
 * 2- Definir lógica da Arquitetura do app
 * 3- Criar Interface
 * 4- Separar Método da Main e aplicar interface
 * 5- Criar Async na MyData
 * 6- Criar método de update no MyData
 * 7- Chamar os métodos na Async
 * 8- Chamar o update
 * -----------------------------------------------------
 */

public class MainActivity extends AppCompatActivity implements ItemClick, BancoDeDadosCallBack {
    NotasAdapter notasAdapter;
    RecyclerView recyclerView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minhas Nota");
        MyData.getInstance().init(this,this);
        MyData.getInstance().loadNotas();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_uma_coluna) {
            staggeredGridLayoutManager.setSpanCount(1);

        } else {
            staggeredGridLayoutManager.setSpanCount(2);

        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickFab(View v) {
        onClickNota(-1);
    }

    @Override
    public void onClickNota(int position) {
        Intent intent = new Intent(this, NotaActivity.class);
        intent.putExtra("position", position);
        startActivityForResult(intent, 555);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("svn", "result: " + resultCode);
        if (resultCode == -1) {
            notasAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(0);
        } else if (resultCode >= 0) {
            MyData.getInstance().deletaNota(resultCode);
            notasAdapter.notifyItemRemoved(resultCode);
        }
    }


    @Override
    public void onLoadNotas() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        notasAdapter = new NotasAdapter(this, MyData.getInstance().getNotasArr());
        recyclerView.setAdapter(notasAdapter);

    }
}
