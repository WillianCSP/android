package br.com.willian.aula05;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.willian.aula05.helpers.GpsHelper;
import br.com.willian.aula05.helpers.PermissaoHelper;
import br.com.willian.aula05.helpers.RetroFitHelper;
import br.com.willian.aula05.interfaces.ClimaApiInterface;
import br.com.willian.aula05.interfaces.GpsCallBack;
import br.com.willian.aula05.interfaces.PermissaoCallBack;
import br.com.willian.aula05.models.ClimaModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//CTRL+shift+v HISTORICO DE copiar colar
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, PermissaoCallBack, GpsCallBack {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                callApi(latLng);
                //adicionaLocalizacao(latLng, false);

            }
        });

        PermissaoHelper.getInstance().verificaPermissao(this, this);


    }

    private void adicionaLocalizacao(LatLng localizacao, boolean isHome, ClimaModel climaModel) {


        String temperatura = climaModel.getMainModel().getTemperatura();
        String nome = climaModel.getNome();

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(localizacao.latitude, localizacao.longitude);
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .icon(isHome ? BitmapDescriptorFactory.fromResource(R.drawable.home) : BitmapDescriptorFactory.fromResource(R.drawable.flag))
                .snippet(temperatura)
                .title(nome));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissaoHelper.getInstance().verificaRespostaDoUsuario(this, requestCode, grantResults);
    }

    @Override
    public void onPermissionSuccess() {
        GpsHelper.getInstance().verificaGps(this, this);
    }

    @Override
    public void onPermissionFail() {
        Toast.makeText(this, "Permissão Negada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGpsSuccess(Location localizacao) {

        LatLng latLng = new LatLng(localizacao.getLatitude(), localizacao.getLongitude());
//        adicionaLocalizacao(latLng, true);
    }

    @Override
    public void onGpsFail() {
        Toast.makeText(this, "Ative o GPS para usar a localização", Toast.LENGTH_SHORT).show();
    }

    private void callApi(final LatLng localizacao) {
        final ClimaApiInterface climaApiInterface = RetroFitHelper.getRetrofitInstance().create(ClimaApiInterface.class);

        Call<ClimaModel> call = climaApiInterface.getClima(localizacao.latitude, localizacao.longitude);

        call.enqueue(new Callback<ClimaModel>() {
            @Override
            public void onResponse(Call<ClimaModel> call, Response<ClimaModel> response) {

                ClimaModel climaModel = response.body();
                // Log.d("willianLog","Temperatura: "+climaModel.getMainModel().getTemperatura()+", "+climaModel.getNome());
                adicionaLocalizacao(localizacao, false, climaModel);
            }

            @Override
            public void onFailure(Call<ClimaModel> call, Throwable t) {
                Log.e("willianLog", "Erro: " + t.getMessage());

            }
        });
    }
}
