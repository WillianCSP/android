package br.com.bsavoini.blocodenotas;

import android.content.Context;

import java.util.ArrayList;

import br.com.bsavoini.blocodenotas.bancodedados.Nota;

/**
 * Created by Bruno on 19/10/2017.
 */

public class MyData {
  Context ctx;

  private static MyData instance;
  private ArrayList<Nota> notasArr;

  public static MyData getInstance() {
    if (instance == null) {
      instance = new MyData();
    }

    return instance;
  }

  public void init(Context ctx) {
    this.ctx = ctx;
    notasArr = new ArrayList<>();
  }

  public ArrayList<Nota> getNotasArr() {
    return notasArr;
  }

  public void loadNotas() {
    notasArr.add(new Nota("Nota 1", "Primeira nota de teste", ctx.getResources().getColor(R.color.branco)));
    notasArr.add(new Nota("Nota 2", "Testando Notas", ctx.getResources().getColor(R.color.verde)));
    notasArr.add(new Nota("Nota 3", "terceira nota", ctx.getResources().getColor(R.color.azul)));
    notasArr.add(new Nota("Nota 4", "Nota número 4", ctx.getResources().getColor(R.color.amarelo)));
    notasArr.add(new Nota("Nota 5", "5a Nota", ctx.getResources().getColor(R.color.laranja)));
    notasArr.add(new Nota("Nota 6", "Nota seis", ctx.getResources().getColor(R.color.branco)));
    notasArr.add(new Nota("Nota 7", "Sétima nota", ctx.getResources().getColor(R.color.azul)));
    notasArr.add(new Nota("Nota 8", "Anotação VIII", ctx.getResources().getColor(R.color.laranja)));
    notasArr.add(new Nota("Nota 9", "Última nota", ctx.getResources().getColor(R.color.verde)));
  }

  public void deletaNota(int index) {
    Nota n = notasArr.get(index);
    notasArr.remove(n);
  }

  public void insereNota(Nota n) {
    notasArr.add(n);
  }

  public Nota getNota(int pos) {
    return notasArr.get(pos);
  }

}
