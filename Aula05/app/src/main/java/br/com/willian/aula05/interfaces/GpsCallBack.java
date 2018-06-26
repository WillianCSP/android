package br.com.willian.aula05.interfaces;

import android.location.Location;

/**
 * Created by Willian on 28/10/2017.
 */

public interface GpsCallBack {

    void onGpsSuccess(Location localizacao);

    void onGpsFail();
}
