package br.com.willian.aula05.helpers;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.willian.aula05.interfaces.GpsCallBack;

/**
 * Created by Willian on 28/10/2017.
 */

public class GpsHelper {

    private static GpsHelper instance;

    public static GpsHelper getInstance(){
        if(instance == null){
            instance = new GpsHelper();
        }

        return instance;
    }

   @SuppressWarnings("MissingPermission")
    public void verificaGps(Activity activity, final GpsCallBack gpsCallBack){

        final LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            boolean checked = false;

            @Override
            public void onLocationChanged(Location location) {
                if(!checked){

                    locationManager.removeUpdates(this);
                    gpsCallBack.onGpsSuccess(location);
                    checked = true;
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                gpsCallBack.onGpsFail();
            }
        };


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
    }
}
