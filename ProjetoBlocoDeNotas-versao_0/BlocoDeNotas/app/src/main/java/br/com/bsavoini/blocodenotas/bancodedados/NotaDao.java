package br.com.bsavoini.blocodenotas.bancodedados;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Willian on 21/10/2017.
 */
@Dao
public interface NotaDao {

    @Query("select * from nota")
    List<Nota> getNotas;

    @Insert
    long insert(Nota nota);

    @Update
    void update(Nota nota);

    @Delete
    void delete(Nota nota);
}
