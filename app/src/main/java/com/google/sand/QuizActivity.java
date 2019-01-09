package com.google.sand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.sand.Adapter.CategoryAdapter;
import com.google.sand.Common.SpaceDecoration;
import com.google.sand.DBHelper.DBHelper;


public class QuizActivity extends AppCompatActivity {

    /*  private ListView listView;
      private String[] subjects;
      private SharedPreferences sharedPreferences;
      public static  SharedPreferences subjectPreferences;
      public  static String SUB_PREF;
      private Toolbar toolbar;*/
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        //get screen height
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels/8;*/
        CategoryAdapter adapter = new CategoryAdapter(QuizActivity.this, DBHelper.getInstance(this).getAllCategories());
        int spaceInPixel = 4;
        recycler.addItemDecoration(new SpaceDecoration(spaceInPixel));
        recycler.setAdapter(adapter);

    }
}
