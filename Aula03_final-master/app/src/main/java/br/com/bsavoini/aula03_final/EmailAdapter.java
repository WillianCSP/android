package br.com.bsavoini.aula03_final;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by trainning on 07/10/2017.
 */

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {
  ArrayList<EmailModel> emailsArr;

  ItemClick callback;

  public EmailAdapter(ItemClick callback,  ArrayList<EmailModel> emailsArr) {
    this.emailsArr = emailsArr;
    this.callback = callback;
  }

  @Override
  public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.item_email, parent, false);

    return new EmailViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final EmailViewHolder holder, final int position) {
    final EmailModel emailModel = emailsArr.get(position);

    holder.txt_sigla.setText(emailModel.getRemetente().charAt(0) + "");

    holder.txt_remetente.setText(emailModel.getRemetente());
    holder.txt_assunto.setText(emailModel.getAssunto());
    holder.txt_mensagem.setText(emailModel.getMensagem());

    String dataFormatada = getDataFormatada(emailModel.getData());
    holder.txt_data.setText(dataFormatada);

    holder.img_estrela.setSelected(emailModel.isFavorito());
    alternaViews(holder, emailModel.isSelecionado());

    holder.box.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       callback.onClickEmail(position);
      }
    });

    holder.box.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View view) {

        emailModel.setSelecionado(!emailModel.isSelecionado());
        notifyDataSetChanged();
        return true;
      }
    });

    holder.img_lixo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        int posicao = holder.getAdapterPosition();
        emailsArr.remove(posicao);
        notifyItemRemoved(posicao);
      }
    });

    holder.img_estrela.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        emailModel.setFavorito(!emailModel.isFavorito());
        notifyDataSetChanged();
      }
    });

  }

  private void alternaViews(EmailViewHolder viewHolder, boolean selecionado){
      viewHolder.img_lixo.setVisibility(selecionado ? View.VISIBLE : View.GONE);
    viewHolder.txt_data.setVisibility(selecionado ? View.GONE : View.VISIBLE);
    viewHolder.box.setBackgroundColor(Color.parseColor(selecionado ? "#DDDDDD":"#FFFFFF"));
    viewHolder.img_estrela.setVisibility(selecionado ? View.GONE : View.VISIBLE);

  }




  //https://developer.android.com/reference/android/icu/text/SimpleDateFormat.html
  //https://developer.android.com/reference/java/text/SimpleDateFormat.html
  private String getDataFormatada(String dataStr) {
    String dataFormatada = "";

    SimpleDateFormat formatoAtual = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoNovo = new SimpleDateFormat("dd MMM");

    try {
      Date dataAtual = formatoAtual.parse(dataStr);
      dataFormatada = formatoNovo.format(dataAtual);
    } catch (Exception erro) {
      return dataStr;
    }
    return dataFormatada;
  }

  @Override
  public int getItemCount() {
    return emailsArr.size();
  }


  public class EmailViewHolder extends RecyclerView.ViewHolder {
    TextView txt_sigla;
    TextView txt_remetente;
    TextView txt_assunto;
    TextView txt_mensagem;
    TextView txt_data;
    View box;
    ImageView img_lixo;
    ImageView img_estrela;

    public EmailViewHolder(final View itemView) {
      super(itemView);
      txt_sigla = (TextView) itemView.findViewById(R.id.txt_sigla);
      txt_remetente = (TextView) itemView.findViewById(R.id.txt_remetente);
      txt_assunto = (TextView) itemView.findViewById(R.id.txt_assunto);
      txt_mensagem = (TextView) itemView.findViewById(R.id.txt_mensagem);
      txt_data = (TextView) itemView.findViewById(R.id.txt_data);
      box = itemView.findViewById(R.id.box);
      img_lixo = (ImageView)itemView.findViewById(R.id.img_lixo);
      img_estrela = (ImageView)itemView.findViewById(R.id.img_estrela);

    }
  }


}