package br.com.willian.aula05.helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Willian on 28/10/2017.
 */

public class RetroFitHelper {
        private static Retrofit retroFit;
        private static  final  String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public static Retrofit getRetrofitInstance(){

        if(retroFit==null){
            retroFit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return  retroFit;
    }
}
