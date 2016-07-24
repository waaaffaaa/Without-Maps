package aj.afnan.pic5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PDFView extends AppCompatActivity {

    public WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);
      //  setTitle("PDF");
       Intent intent = getIntent();
      Bundle bundle = intent.getExtras();
       String name= bundle.getString("name");




        webview = (WebView) findViewById(R.id.webViewPDF);
        // webview.setWebViewClient(new MywebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.loadUrl(name);


/*
        WebView webView= new WebView( this);
        setContentView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.loadUrl("http://tvtc.gov.sa/Arabic/Departments/Departments/pt/InformationCenter/ReportsAndGuides/Documents/training_guids.pdf");
        setContentView(webView);

*/
       // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(name)));


          /*  webView= (WebView)findViewById(R.id.webView);
            WebSettings webSettings = webView.getSettings();
            webView.getSettings().setLoadWithOverviewMode(true);
            webSettings.setUseWideViewPort(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setPluginState(WebSettings.PluginState.ON);*/

    }

    public class MywebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView View,String url) {
///mmbbbbjoijioioi
            if (Uri.parse(url).getHost().equals((""))) {
                return false;
            }
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
            return true;
        }
    }
}
