package br.com.willian.aula02;

/**
 * Created by Willian on 30/09/2017.
 */

public class PaisModel {

      private  int id;
      private  String continente;
      private  String nome;
      private  String capital;
      private  String sigla;
      private  int fotoID;
      private  int bandeiraID;

    public PaisModel(int id, String continente, String nome, String capital, String sigla, int bandeiraID, int fotoID) {
        this.id = id;
        this.continente = continente;
        this.nome = nome;
        this.capital = capital;
        this.sigla = sigla;
        this.fotoID = fotoID;
        this.bandeiraID = bandeiraID;
    }

    public int getId() {
        return id;
    }

    public String getContinente() {
        return continente;
    }

    public String getNome() {
        return nome;
    }

    public String getCapital() {
        return capital;
    }

    public String getSigla() {
        return sigla;
    }

    public int getFotoID() {
        return fotoID;
    }

    public int getBandeiraID() {
        return bandeiraID;
    }
}
