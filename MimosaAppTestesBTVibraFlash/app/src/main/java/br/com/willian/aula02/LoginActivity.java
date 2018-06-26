package br.com.willian.aula02;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

import java.io.IOException;
import java.security.Policy;

public class LoginActivity extends AppCompatActivity {


    SharedPreferences preferenciasDeUsuario;
    MediaPlayer som;
    Camera cam;
    Camera.Parameters params;
    int sleepMS=(1/10)*50;
    int flashCount=10;
    boolean isLighOn = false;
    private static final int LED_NOTIFICATION_ID= 0;

@Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, info);
                if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                    try {
                        // Gets to here OK
                        camera = Camera.open(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                        //  throws runtime exception :"Failed to connect to camera service"
                    }
                }
            }
        }
    }


    @Override
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MimosaApp");
        preferenciasDeUsuario = getSharedPreferences("usuario", MODE_PRIVATE);
        boolean lembrar = preferenciasDeUsuario.getBoolean("lembrar", false);
        Log.d("snv", "Lembrar senha:"+lembrar);
        Toast.makeText(this, ""+lembrar, Toast.LENGTH_LONG).show();

        if(lembrar){
            abreActivity_();
        }else{
            setContentView(R.layout.activity_login);

        }
//        try{
//
//
//        ImageView v = (ImageView) findViewById(R.id.imgview);
//                    Glide.with(this)
//                .load(R.drawable.vaca)
//                .asGif()
//                .placeholder(R.drawable.vaca)
//                .crossFade()
//                .into(v);
//        }catch(Exception e){
//            Log.e("MyApp"," Exception: "+e );
//        }
//        Glide.with(this)
//                .load("http://i.imgur.com/1ALnB2s.gif")
//                .asGif()
//                .placeholder(R.drawable.aaa)
//                .crossFade()
//                .into(v);
//        gif();
        som = MediaPlayer.create(this, R.raw.vaca);
        som.start();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0, 1000, 500};

// The '-1' here means to vibrate once, as '-1' is out of bounds in the pattern array
        v.vibrate(pattern, 0);
//        RedFlashLight();


        try {

            flash();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void flash() throws IOException, InterruptedException {


        cam = Camera.open();
        params =  cam.getParameters();
        cam.setPreviewTexture(new SurfaceTexture(0));
        cam.startPreview();

        for (int i = 0; i < 10; i++) {
            flipFlash();
            Thread.sleep(200);
            flipFlash();
            Thread.sleep(500);
        }
        cam.stopPreview();
        cam.release();
    }

    private void flipFlash(){
        if (isLighOn) {

            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            cam.setParameters(params);
            isLighOn = false;
        } else{
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            cam.setParameters(params);
            isLighOn = true;
        }
    }

    private void RedFlashLight() {
        NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE);
        Notification notif = new Notification();
        notif.ledARGB = 0xFFff0000;
        notif.flags = Notification.FLAG_SHOW_LIGHTS;
        notif.ledOnMS = 100;
        notif.ledOffMS = 100;
        nm.notify(LED_NOTIFICATION_ID, notif);nm.cancelAll();
    }

    public void gif(){
        ImageView imageView = (ImageView) findViewById(R.id.imgview);
        GlideDrawableImageViewTarget imageViewPreview = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this)
                .load("http://i.imgur.com/1ALnB2s.gif")
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.e("MyApp", "onException: "+model+" Exception: "+e );
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Log.e("MyApp", "onResourceReady: "+model );
                        return false;
                    }
                })
                .into(imageViewPreview);
    }

    public void onClickEntrar(View v) {
        EditText edt_usuario = (EditText) findViewById(R.id.edt_usuario);
        EditText edt_senha = (EditText) findViewById(R.id.edt_senha);

        String usuario = edt_usuario.getText().toString();
        String senha = edt_senha.getText().toString();

        boolean loginValido = login(usuario, senha);

        if(loginValido){
            salvaLogin();
            abreActivity_();
        }else{
            Toast.makeText(this, "Tente novamente", Toast.LENGTH_LONG).show();
        }

//        String msg = loginValido ? "Login com sucesso!" : "Tente novamente";






    }

    private void abreActivity_(){
        Intent minha_intent = new Intent(this, ContinenteActivity.class);
        startActivity(minha_intent);
        finish();
    }

    private void abreActivity1_(){
        Intent minha_intent = new Intent(this, LoginActivity.class);
        startActivity(minha_intent);
//        finish();
    }

    private void salvaLogin(){

        CheckBox chk_lembrar = (CheckBox) findViewById(R.id.chk_lembrar);
        boolean lembrar = chk_lembrar.isChecked();
        Log.d("svn","Lembrar:"+lembrar);

        preferenciasDeUsuario.edit().putBoolean("lembrar",lembrar).apply();
    }

    private boolean login(String usuario, String senha) {
        if (usuario.equals("aaa") && senha.equals("123")) {
            return true;
        }

        return false;
    }
}
