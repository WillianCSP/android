package br.com.bsavoini.aula03_final;

/**
 * Created by trainning on 07/10/2017.
 */

public class EmailModel {
  private int id;
  private String remetente;
  private String assunto;
  private String mensagem;
  private String data;
  private boolean favorito;
  private boolean selecionado;

  public EmailModel(int id, String remetente, String assunto, String mensagem, String data) {
    this.id = id;
    this.remetente = remetente;
    this.assunto = assunto;
    this.mensagem = mensagem;
    this.data = data;
    favorito = false;
    selecionado = false;
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

  public boolean isSelecionado() {
    return selecionado;
  }

  public void setFavorito(boolean favorito) {
    this.favorito = favorito;
  }

  public void setSelecionado(boolean selecionado) {
    this.selecionado = selecionado;
  }
}