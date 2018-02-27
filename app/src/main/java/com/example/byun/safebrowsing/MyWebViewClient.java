package com.example.byun.safebrowsing;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by byun on 2018-02-11.
 */

public class MyWebViewClient extends WebViewClient {
    @Override
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
        super.onSafeBrowsingHit(view, request, threatType, callback);

        //위협된 사이트에 접근 시 자동으로 "backToSafety" 이동
        //단 이 함수는 반드시 safeBrowse 초기화가 이루어져야 호출

        callback.backToSafety(true); //값이 true 일 경우 safetyBrowsing에 알림
        Toast.makeText(view.getContext(), "Unsafe web page blocked.",
                Toast.LENGTH_LONG).show();

    }


}



