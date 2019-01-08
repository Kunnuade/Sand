package com.google.sand;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetailActivity extends AppCompatActivity {
 private ListView listView;
 private String title[];
    private SharedPreferences sharedPreferences;
    public static  SharedPreferences quizPreferences;
    public  static String QUIZ_PREF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        setupUIViews();
    }
    private void setupUIViews(){

        listView = (ListView) findViewById(R.id.lvsubjectdetails);
        quizPreferences = getSharedPreferences(String.valueOf(title), MODE_PRIVATE);
        setupListView();
    }
    private void setupListView() {
        String subject_selected = SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF, null);
        String[] syllabus = new String[] {};
        title = getResources().getStringArray(R.array.title);
        if(subject_selected.equalsIgnoreCase("Mathematics" )) {
            syllabus = getResources().getStringArray(R.array.Mathematics);
        }
        else if(subject_selected.equalsIgnoreCase("English")) {
            syllabus = getResources().getStringArray(R.array.English);
        }
        else if(subject_selected.equalsIgnoreCase("History")) {
            syllabus = getResources().getStringArray(R.array.History);
        }
        else if(subject_selected.equalsIgnoreCase("WildLife")) {
            syllabus = getResources().getStringArray(R.array.Wildlife);
        }

        SubjectDetailsAdapter subjectDetailsAdapter = new SubjectDetailsAdapter(this, title, syllabus);
        listView.setAdapter(subjectDetailsAdapter);
    }
    public class SubjectDetailsAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,syllabus;
        private String[] titleArray;
        private String[] syllabusArray;


        public SubjectDetailsAdapter(Context context, String[] title, String[] syllabus){
            mContext = context;
            titleArray = title;
            syllabusArray = syllabus;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {

                convertView = getLayoutInflater().inflate(R.layout.subjectdetailsitem, null);

                title = (TextView) convertView.findViewById(R.id.tvsubjectTitle);
                syllabus = (TextView) convertView.findViewById(R.id.tvsyllabus);


                title.setText(titleArray[position]);
                syllabus.setText(syllabusArray[position]);

            }
            return convertView;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

