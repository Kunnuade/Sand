package com.google.sand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailsInfo extends AppCompatActivity {
private WebView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);
        setupUIViews();
    }
    private void setupUIViews(){

        listView = (WebView) findViewById(R.id.WebView2);
        setupListView();
    }
    private void setupListView() {
        String myinfo;
        String quiz_selected = SubjectDetailActivity.quizPreferences.getString(SubjectDetailActivity.QUIZ_PREF, null);
        String[] title = getResources().getStringArray(R.array.title);
        if(quiz_selected.equalsIgnoreCase("unit 1")) {
            myinfo = "file:///android_asset/about.html";
            listView.getSettings().setJavaScriptEnabled(true);
            listView.loadUrl(myinfo);

        }
        else if(quiz_selected.equalsIgnoreCase("unit 2")) {
            myinfo = "file:///android_asset/about.html";
            listView.getSettings().setJavaScriptEnabled(true);
            listView.loadUrl(myinfo);
        }
        else if(quiz_selected.equalsIgnoreCase("unit 3")) {
            myinfo = "file:///android_asset/about.html";
            listView.getSettings().setJavaScriptEnabled(true);
            listView.loadUrl(myinfo);
        }

      //  SubjectDetailsAdapter subjectDetailsAdapter = new SubjectDetailsAdapter(this, title, syllabus);
      //  listView.setAdapter(subjectDetailsAdapter);
    }
    }

