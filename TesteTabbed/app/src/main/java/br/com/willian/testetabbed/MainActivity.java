package br.com.willian.testetabbed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost) findViewById(R.id.tab_host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("1");
        spec.setContent(R.id.tab_one_container);
        spec.setIndicator("1");
        host.addTab(spec);

        TabHost.TabSpec spec2 = host.newTabSpec("2");
//        spec = host.newTabSpec("2");
        spec2.setContent(R.id.tab_two_container);
        spec2.setIndicator("2");
        host.addTab(spec2);

        try {

            WebView webview = (WebView) findViewById(R.id.w1);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.uol.com");
            webview.setWebViewClient(new WebViewClient());
            spec.setContent(R.id.w1);

            WebView webview1 = (WebView) findViewById(R.id.w2);
            webview1.getSettings().setJavaScriptEnabled(true);
            webview1.loadUrl("http://www.unifrota.com.br");
            webview1.setWebViewClient(new WebViewClient());
            spec2.setContent(R.id.w2);

        }catch(Exception e){

            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}
