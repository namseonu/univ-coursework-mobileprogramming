package com.example.mobileprogramming.course05.part02;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class WebView02Activity extends AppCompatActivity {
    WebView browser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_02);

        browser = (WebView) findViewById(R.id.webkit);

        // allow scripts
        browser.getSettings().setJavaScriptEnabled(true);

        // page navigation
        browser.setWebViewClient(new WebViewClient());

        browser.loadUrl("https://www.ebay.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web_view_02, menu);
        return true;
    }   // onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String option = item.getTitle().toString();

        if(option.equals("Forward Page"))
            browser.goForward();    // method supported by browser
        if(option.equals("Back Page"))
            browser.goBack();       // method supported by browser

        return true;
    }
}
