package com.google.sand;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class FactActivity extends AppCompatActivity {
    int days = 30;
    String[] facts = new String[days];
    private TextView text;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < days; i++) {
            facts[i] = Facts.prevDaily(getApplicationContext(), i);
            text = findViewById(R.id.tvfact);
            text.setText(facts[i]);
        }
        setContentView(R.layout.activity_fact);
        setupUIViews();
        //randomColor();
    }

    /* private int randomColor() {
         Random random = new Random();
         String[] colorsArr = getResources().getStringArray(R.array.colors);
         return Color.parseColor(colorsArr[random.nextInt(colorsArr.length)]);
     }*/
    private void setupUIViews() {
        listView = findViewById(R.id.lvfacts);
      //  setupListView();
    }
/*
    private void setupListView() {
        FactsAdapter simpleAdapter = new FactsAdapter(this, facts);
        listView.setAdapter(simpleAdapter);
    }

    public class FactsAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView text;
        private String[] factArray;


        public FactsAdapter(Context context, String[] facts) {
            mContext = context;
            factArray = facts;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return days;
        }

        @Override
        public Object getItem(int position) {
            return factArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {

                convertView = getLayoutInflater().inflate(R.layout.fact_item, null);

                text = (TextView) convertView.findViewById(R.id.tvmain);

                text.setText(factArray[position]);
            }
            return convertView;
        }
    }*/
}