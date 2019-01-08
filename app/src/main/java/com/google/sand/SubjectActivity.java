package com.google.sand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.sand.Utils.LetterImageView;


public class SubjectActivity extends AppCompatActivity {

    private ListView listView;
    private String[] subjects;
    private SharedPreferences sharedPreferences;
    public static  SharedPreferences subjectPreferences;
    public  static String SUB_PREF;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        setupUIViews();
       // initToolbar();
    }
    private void setupUIViews(){

        listView = (ListView) findViewById(R.id.lvsubject);
        subjectPreferences = getSharedPreferences(String.valueOf(subjects), MODE_PRIVATE);
        setupListView();
    }

    private void setupListView(){
        subjects = getResources().getStringArray(R.array.Subjects);
        SubjectAdapter subjectAdapter = new SubjectAdapter(this,R.layout.subject_item,subjects);
        listView.setAdapter(subjectAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                   subjectPreferences.edit().putString(SUB_PREF, "Mathematics").apply();
                    Intent intent = new Intent(SubjectActivity.this, SubjectDetailActivity.class);
                    startActivity(intent);
                }
               else if(position == 1) {
                    subjectPreferences.edit().putString(SUB_PREF, "English").apply();
                    Intent intent = new Intent(SubjectActivity.this, SubjectDetailActivity.class);
                    startActivity(intent);
                }
                else if(position == 2) {
                    subjectPreferences.edit().putString(SUB_PREF, "History").apply();
                    Intent intent = new Intent(SubjectActivity.this, SubjectDetailActivity.class);
                    startActivity(intent);
                }
                else if(position == 3) {
                    subjectPreferences.edit().putString(SUB_PREF, "Wildlife").apply();
                    Intent intent = new Intent(SubjectActivity.this, SubjectDetailActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public class SubjectAdapter extends ArrayAdapter{
            private int resource;
            private LayoutInflater layoutInflater;
            private String[] subjects = new String[]{};


        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subjects = objects;
            layoutInflater = (LayoutInflater)context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivlogo = (LetterImageView)convertView.findViewById(R.id.ivlettersubject);
                holder.tvsubject = (TextView)convertView.findViewById(R.id.tvsubject);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }
            holder.ivlogo.setOval(true);
            holder.ivlogo.setLetter(subjects[position].charAt(0));
            holder.tvsubject.setText(subjects[position]);

            return convertView;
        }
        class ViewHolder {
            private LetterImageView ivlogo;
            private TextView tvsubject;
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
