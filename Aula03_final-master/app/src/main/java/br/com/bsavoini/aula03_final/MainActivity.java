package br.com.bsavoini.aula03_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Caixa de Entrada");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        EmailAdapter adapter = new EmailAdapter(this,MyData.getInstance().getEmails());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickEmail(int index) {
        Intent intent = new Intent(this,EmailActivity.class);
        intent.putExtra("id",index);
        startActivity(intent);

    }
}