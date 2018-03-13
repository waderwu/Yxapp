package com.example.yxapp;



import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test","ok3");
        final WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this),"Android");


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view,url);
                webView.loadUrl("javascript:document.onselectionchange = function() { Android.showToast(window.getSelection().toString()); };");
            }
        });

//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView webview1, int newProgress){
//                super.onProgressChanged(webview1,newProgress);
//                boolean flag = true;
//                if (newProgress>60 && flag){
//                    flag = false;
//                    webView.loadUrl("javascript:document.onselectionchange = function() { Android.showToast(window.getSelection().toString()); };");
//                }
//            }
//        });

        Button button = findViewById(R.id.button1);
        final Translate translate = new Translate(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.eturl);

                String url = editText.getText().toString();
                Log.d("hahh",url);

                Log.d("hahaha",translate.getTraslation(url));
                if (url.length() > 4){
                    Log.d("test","ok,"+url);
                    webView.loadUrl(url);
                }else{
                    Log.d("test","ok2");
                    webView.loadUrl("https://www.baidu.com");
                }
            }
        });
    }
}

