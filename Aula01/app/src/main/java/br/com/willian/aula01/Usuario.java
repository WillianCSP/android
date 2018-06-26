package br.com.willian.aula01;

/**
 * Created by trainning on 23/09/2017.
 */

public class Usuario {

     int idade;
     String nome;
     boolean estaLogado;

    public Usuario(String nome) {


        this.nome = nome;
        this.estaLogado = false;

    }

    public void login() {

        this.estaLogado = true;
    }

    public void logout() {

        this.estaLogado = false;
    }

    public void informaAno(int ano) {
        this.idade = 2017 - ano;


    }

    public String getDados(){

        String dados;
        dados = "Nome: "+nome+"\nIdade: "+idade;
//        if(estaLogado)
//            dados = dados+" Está logado";
//        else
//            dados = dados+" Está deslogado";

        dados   += estaLogado ? " Está logado" : " Está deslogado";
        return dados;
    }


}
