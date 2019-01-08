package com.google.sand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {
        private android.support.v7.widget.Toolbar toolbar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String myabout = "file:///android_asset/about.html";
        WebView view = (WebView) this.findViewById(R.id.WebView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(myabout);


    }

    }

