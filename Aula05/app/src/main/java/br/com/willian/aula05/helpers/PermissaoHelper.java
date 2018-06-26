package br.com.willian.aula05.helpers;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import br.com.willian.aula05.interfaces.PermissaoCallBack;

/**
 * Created by Willian on 28/10/2017.
 */

public class PermissaoHelper {

    private static PermissaoHelper instance;
    private String[] permissoes;
    private int code =1;

    public static PermissaoHelper getInstance() {

        if (instance == null) {
            instance = new PermissaoHelper();
            instance.permissoes = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        }

        return instance;
    }

    public void verificaPermissao(Activity activity, PermissaoCallBack permissaoCallBack) {


        int resultado = ContextCompat.checkSelfPermission(activity, permissoes[0]);
        if (resultado == PackageManager.PERMISSION_GRANTED) {

            permissaoCallBack.onPermissionSuccess();

        } else {
            pedirPermissao(activity);
        }
    }

    public void pedirPermissao(Activity activity) {

        ActivityCompat.requestPermissions(activity,permissoes,code);

    }

    public void verificaRespostaDoUsuario(PermissaoCallBack permissaoCallBack, int code, int[] respostasUsuario) {

        if(this.code == code){
            if(respostasUsuario[0] == PackageManager.PERMISSION_GRANTED){
                permissaoCallBack.onPermissionSuccess();
            }else{
                permissaoCallBack.onPermissionFail();

            }
        }

    }


}
