package br.com.willian.aula_3_listas;

/**
 * Created by Willian on 07/10/2017.
 */

public class EmailModel {

    private int id;
    private String remetente;
    private String assunto;
    private String mensagem;
    private String data;
    private boolean favorito;
    private boolean lido;

    public EmailModel(int id, String remetente, String assunto, String mensagem, String data) {
        this.id = id;
        this.remetente = remetente;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.data = data;
        this.favorito = false;
        this.lido = false;

    }

    public int getId() {
        return id;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getData() {
        return data;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public boolean isLido() {
        return lido;
    }

    public void setFavorito(boolean favorito){
        this.favorito = favorito;
    }

    public void setLido(boolean lido){

        this.lido = lido;
    }
}
