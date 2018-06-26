package br.com.bsavoini.blocodenotas.bancodedados;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Bruno on 14/10/2017.
 */
@Entity
public class Nota {

    @PrimaryKey(autoGenerate = true)
    private long uid;

    @ColumnInfo(name = "titulo")
    private String titulo;

    @ColumnInfo(name = "nota")
    private String nota;

    @ColumnInfo(name = "cor")
    private int cor;

    public Nota(String titulo, String nota, int cor) {
        this.titulo = titulo;
        this.nota = nota;
        this.cor = cor;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
}