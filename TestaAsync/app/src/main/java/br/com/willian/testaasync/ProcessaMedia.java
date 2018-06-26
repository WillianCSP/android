package br.com.willian.testaasync;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by Willian on 21/10/2017.
 */
//paramentro, progresso, retorno
public class ProcessaMedia extends AsyncTask<Integer,String,Double> {


    TextView txt_status;

    public ProcessaMedia(TextView txt_status){
        this.txt_status = txt_status;

    }

    @Override
    protected Double doInBackground(Integer... params) {
        int soma = params[0];
        int n =99999;
        for (int i = 0; i < n; i++) {
            soma += i;
            try{
                publishProgress("Processando "+i+" de: "+n);
                Thread.sleep(100);
            }catch (Exception e ){
                e.printStackTrace();
            }
        }

        double media = (double)soma/n;
        return media;
    }


    //responsavel pela UI(thread usuario)
    @Override
    protected void onPostExecute(Double media) {
        super.onPostExecute(media);
        txt_status.setText("Valor: "+media);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        txt_status.setText(values[0]);
    }

}
