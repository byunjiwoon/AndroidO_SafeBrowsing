package com.example.byun.safebrowsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    private boolean IsInitialized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView)findViewById(R.id.webView);
        wv.setWebViewClient(new MyWebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
        IsInitialized = false;
        wv.startSafeBrowsing(this, new ValueCallback<Boolean>() {
            @Override
            public void onReceiveValue(Boolean value) {
                IsInitialized = true;
                //알려진 위협 요소에 대한 보호를 위해, WebView 개체의 loadUrl()메서드를 호출하기 전에
                //IsInitialized을 초기화할 때까지 기다린다.
                if(!value)
                    Toast.makeText(getApplicationContext(),"Unable to initialize Safe Browsing!.",Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView =(TextView)findViewById(R.id.tv);
        textView.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        wv.loadUrl("http://testsafebrowsing.appspot.com/");//http://cappleblog.co.kr/534
                        //http://phishing.safebrowsingtest.com/

                    }
                }
        );

    }
}
