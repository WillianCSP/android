package br.com.willian.testaasync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickProcessa(View v) {
        TextView txt_status = (TextView) findViewById(R.id.txt_status);
        ProcessaMedia processaMedia = new ProcessaMedia(txt_status);
        processaMedia.execute(1000);





    }


}
