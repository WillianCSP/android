package br.com.willian.aula_3_listas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Willian on 07/10/2017.
 */

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder>{

    ArrayList<EmailModel> emailsArr;

    public EmailAdapter(ArrayList<EmailModel> emailsArr){
        this.emailsArr = emailsArr;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email,parent,false);

        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        EmailModel emailModel = emailsArr.get(position);
        holder.txt_sigla.setText(emailModel.getRemetente().charAt(0)+"");
        holder.txt_remetente.setText(emailModel.getRemetente());
        holder.txt_assunto.setText(emailModel.getAssunto());
        holder.txt_mensagem.setText(emailModel.getMensagem());

        String dataFormatada = getDataFormatada(emailModel.getData());
        holder.txt_data.setText(dataFormatada);
    }

    private String getDataFormatada(String dataStr){

        String dataFormatada = "";
        SimpleDateFormat formatoAtual = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoNovo = new SimpleDateFormat("dd MMM");

        try {
            Date dataAtual = formatoAtual.parse(dataStr);
            dataFormatada = formatoNovo.format(dataAtual);
        } catch (ParseException e) {
            e.printStackTrace();
            dataFormatada = dataStr;
        }


        return dataFormatada;
    }

    @Override
    public int getItemCount() {
        return this.emailsArr.size();
    }


    public class EmailViewHolder extends RecyclerView.ViewHolder{

        TextView txt_sigla;
        TextView txt_remetente;
        TextView txt_assunto;
        TextView txt_mensagem;
        TextView txt_data;

        public EmailViewHolder(View itemView) {
            super(itemView);
            txt_sigla = (TextView) itemView.findViewById(R.id.txt_sigla);
            txt_remetente = (TextView) itemView.findViewById(R.id.txt_remetente);
            txt_assunto = (TextView) itemView.findViewById(R.id.txt_assunto);
            txt_mensagem = (TextView) itemView.findViewById(R.id.txt_mensagem);
            txt_data = (TextView) itemView.findViewById(R.id.txt_data);
        }
    }
}
