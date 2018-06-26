package br.com.bsavoini.aula02_set;


/**
 * Created by android on 25/03/2017.
 */

public class PaisModel {
    private int id;
    private String continente;
    private String nome;
    private String capital;
    private String sigla;


    private int fotoID;
    private int bandeiraID;

    public PaisModel(int id,
                     String continente,
                     String nome,
                     String sigla,
                     String capital,
                     int bandeiraID,
                     int fotoID) {

        this.id = id;
        this.continente = continente;
        this.nome = nome;
        this.capital = capital;
        this.sigla = sigla;
        this.fotoID = fotoID;
        this.bandeiraID = bandeiraID;
    }

    public String getContinente() {
        return continente;
    }

    public int getId() {
        return id;
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
