package br.com.bsavoini.blocodenotas;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.bsavoini.blocodenotas.bancodedados.Nota;
import br.com.bsavoini.blocodenotas.interfaces.ItemClick;

/**
 * Created by Bruno on 19/10/2017.
 */

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotasViewHolder> {
  List<Nota> notas;
  ItemClick itemClick;

  public NotasAdapter(ItemClick itemClick, List<Nota> notas) {
    this.notas = notas;
    this.itemClick = itemClick;
  }

  @Override
  public NotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new NotasViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false));
  }

  @Override
  public void onBindViewHolder(final NotasViewHolder holder, int position) {
    Nota nota = notas.get(position);
    holder.txt_nota.setText(nota.getNota());
    holder.txt_titulo.setText(nota.getTitulo());
    holder.card.setCardBackgroundColor(nota.getCor());
    holder.card.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        itemClick.onClickNota(holder.getAdapterPosition());
      }
    });
  }

  @Override
  public int getItemCount() {
    return notas.size();
  }

  public class NotasViewHolder extends RecyclerView.ViewHolder {

    CardView card;
    TextView txt_titulo;
    TextView txt_nota;

    public NotasViewHolder(View itemView) {
      super(itemView);

      card = (CardView) itemView.findViewById(R.id.card);
      txt_titulo = (TextView) itemView.findViewById(R.id.txt_titulo);
      txt_nota = (TextView) itemView.findViewById(R.id.txt_nota);
    }
  }
}
