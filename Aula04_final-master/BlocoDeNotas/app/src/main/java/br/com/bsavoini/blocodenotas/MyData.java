package br.com.bsavoini.blocodenotas;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.bsavoini.blocodenotas.bancodedados.BancoDeDados;
import br.com.bsavoini.blocodenotas.bancodedados.Nota;
import br.com.bsavoini.blocodenotas.interfaces.BancoDeDadosCallBack;

/**
 * Created by Bruno on 19/10/2017.
 */

public class MyData {
    Context ctx;
    BancoDeDados db;
    BancoDeDadosCallBack callBack;

    public enum FUNCAO {
        Carregar, Inserir, Deletar, Alterar;

    }

    private static MyData instance;
    private ArrayList<Nota> notasArr;

    public static MyData getInstance() {
        if (instance == null) {
            instance = new MyData();
        }

        return instance;
    }

    public void init(Context ctx, BancoDeDadosCallBack callBack) {
        this.ctx = ctx;
        this.callBack = callBack;
        db = Room.databaseBuilder(ctx, BancoDeDados.class, "primeiro-banco").build();
        notasArr = new ArrayList<>();
    }

    public ArrayList<Nota> getNotasArr() {
        return notasArr;
    }

    public void loadNotas() {
        MinhaAsync minhaAsync = new MinhaAsync(FUNCAO.Carregar);
        minhaAsync.execute();


    }

    public void alteraNota(Nota n){

        MinhaAsync minhaAsync = new MinhaAsync(FUNCAO.Alterar);
        minhaAsync.execute(n);
    }

    public void deletaNota(int index) {
        Nota n = notasArr.get(index);
        notasArr.remove(n);

        MinhaAsync minhaAsync = new MinhaAsync(FUNCAO.Deletar);
        minhaAsync.execute(n);
    }

    public void insereNota(Nota n) {

        notasArr.add(n);
        MinhaAsync minhaAsync = new MinhaAsync(FUNCAO.Inserir);
        minhaAsync.execute(n);//chama doInBackground
    }

    public Nota getNota(int pos) {
        return notasArr.get(pos);
    }


    private class MinhaAsync extends AsyncTask<Object, Void, List<Nota>> {

        FUNCAO funcao;

        public MinhaAsync(FUNCAO funcao) {
            this.funcao = funcao;

        }

        @Override
        protected List<Nota> doInBackground(Object... objects) {

            Nota nota = null;
            if (objects.length > 0)//ou verificar enum
                nota = (Nota) objects[0];

            switch (funcao) {
                case Carregar:
                    List<Nota> notasList = db.notasDAO().getNotas();//SHIFT+F6 renomeia método em todas classes
                    return notasList;

                case Inserir:

                    long id = db.notasDAO().insert(nota);
                    int index = notasArr.indexOf(nota);
                    notasArr.get(index).setUid(id);
                    break;
                case Alterar:
                    db.notasDAO().update(nota);
                    break;
                case Deletar:
                    db.notasDAO().delete(nota);
                    break;
            }


            return null;
        }

        @Override//parametro eh o retorno do doInBackground
        protected void onPostExecute(List<Nota> notas) {
            super.onPostExecute(notas);
            if (notas != null) {
                notasArr = new ArrayList<>();
                notasArr.addAll(notas);
                callBack.onLoadNotas();
            }
            ;
        }
    }

}
