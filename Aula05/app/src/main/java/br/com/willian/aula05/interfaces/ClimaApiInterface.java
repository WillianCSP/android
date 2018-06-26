package br.com.willian.aula05.interfaces;

import br.com.willian.aula05.models.ClimaModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Willian on 28/10/2017.
 */

public interface ClimaApiInterface {

    String chave = "&appid=056677e4790b34379b4274ad0e325d55";
    String unidadeDeMedida = "&units=metric";

    //api.openweathermap.org/data/2.5/weather?lat=35&lon=139
    @GET("weather?" + chave + unidadeDeMedida)
    Call<ClimaModel> getClima(@Query("lat") double latitude, @Query("lon") double longitude);

}
