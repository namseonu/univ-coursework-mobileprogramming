package com.example.mobileprogramming.course05.part02;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class WebView01Activity extends AppCompatActivity {
    WebView browser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_01);

        browser = (WebView) findViewById(R.id.webkit);

        // allow scripts
        browser.getSettings().setJavaScriptEnabled(true);

        // page navigation
        browser.setWebViewClient(new WebViewClient());

        browser.loadUrl("https://www.ebay.com");
    }
}
