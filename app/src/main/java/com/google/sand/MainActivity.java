package com.google.sand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    TextView factbox;
    // private android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factbox = (TextView) findViewById(R.id.textfact);
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set daily fact
        factbox.setText(Facts.dailyFact(getApplicationContext()));


        // setupUIViews();
        //   initToolbar();
    }


    private void next() {
        factbox.setText(Facts.nextFact());
    }

    private void prev() {
        factbox.setText(Facts.prevFact());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.nav_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "this application is good for kids to learn, try it out and i hope you'll like it.";
            String ShareSub = "Share Sand now";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, ShareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "Share Using"));
        } else if (item.getItemId() == R.id.nav_feedback) {
            Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_about) {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_facts) {
            Intent intent = new Intent(getApplicationContext(), FactActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_subjects) {
            Intent intent = new Intent(getApplicationContext(), SubjectActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_quizzes) {
            Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_games) {
            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void genFact(View view) {
        next();
    }
}
