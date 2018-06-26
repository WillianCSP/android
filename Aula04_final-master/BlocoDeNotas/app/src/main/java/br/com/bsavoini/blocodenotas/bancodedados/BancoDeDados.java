package br.com.bsavoini.blocodenotas.bancodedados;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Willian on 28/10/2017.
 */
@Database(entities = {Nota.class}, version= 1)
public abstract class BancoDeDados extends RoomDatabase {

    public abstract NotaDAO notasDAO();
}
