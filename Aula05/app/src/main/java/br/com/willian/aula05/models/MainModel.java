package br.com.willian.aula05.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Willian on 28/10/2017.
 */

public class MainModel {

    @SerializedName("temp")
    String temperatura;


    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
