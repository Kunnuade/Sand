package com.google.sand;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
 private ListView listView;
 private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setupUIViews();

    }
    private void setupUIViews(){
        listView = findViewById(R.id.lvmain);
        setupListView();
    }

    private  void  setupListView() {
        String[] title = {
        "Bodmas", "Memory Game", "Trace it", "Spell the word", "Whats it", "Word search", "puzzle", "anagram", "spot the difference",
        "pick the odd one out", "dot-to-dot"};
        String[] description = {
                "Description 1", "Description 2", "Description 3", "Description 4", "Description 5", "Description 6", "Description 7", "Description 8",
                "Description 9", "Description 10", "Description 11"
        };

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);
    }
    public class SimpleAdapter extends BaseAdapter{
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;


        public SimpleAdapter(Context context, String[] title, String[] description){
            mContext = context;
            titleArray = title;
            descriptionArray = description;
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

                convertView = getLayoutInflater().inflate(R.layout.game_item, null);

                title = (TextView) convertView.findViewById(R.id.tvmain);
                description = (TextView) convertView.findViewById(R.id.tvDescription);
                imageView = (ImageView) convertView.findViewById(R.id.ivmain);

                title.setText(titleArray[position-1]);
                description.setText(descriptionArray[position]);
                if (titleArray[position].equalsIgnoreCase("Bodmas")) {
                    imageView.setImageResource(R.drawable.ic_info_black_24dp);
                } else if (titleArray[position].equalsIgnoreCase("Memory Game")) {
                    imageView.setImageResource(R.mipmap.baseline_exit_to_app_black_18dp);
                } else if (titleArray[position].equalsIgnoreCase("Trace it")) {
                    imageView.setImageResource(R.mipmap.baseline_all_inbox_black_18dp);
                } else if (titleArray[position].equalsIgnoreCase("Spell the word")) {
                    imageView.setImageResource(R.mipmap.baseline_feedback_black_18dp);
                } else if (titleArray[position].equalsIgnoreCase("Whats in the picture")) {
                    imageView.setImageResource(R.mipmap.baseline_copyright_black_18dp);
                } else if (titleArray[position].equalsIgnoreCase("Word search")) {
                    imageView.setImageResource(R.mipmap.baseline_toc_black_18dp);
                }else if(titleArray[position].equalsIgnoreCase("Puzzles")){
                    imageView.setImageResource(R.mipmap.baseline_note_black_18dp);
                }else if(titleArray[position].equalsIgnoreCase("anagram")){
                    imageView.setImageResource(R.drawable.ic_notifications_black_24dp);
                }else if(titleArray[position].equalsIgnoreCase("spot the difference")){
                    imageView.setImageResource(R.drawable.ic_sync_black_24dp);
                }else if(titleArray[position].equalsIgnoreCase("odd one out")){
                    imageView.setImageResource(R.mipmap.baseline_comment_black_18dp);
                }else if(titleArray[position].equalsIgnoreCase("dot-to-dot")){
                    imageView.setImageResource(R.mipmap.baseline_account_circle_black_18dp);
                }

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
