package com.psttrmtc.rssfeedreaderassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    GridView gridView;

    ArrayList<NewsItem> newsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.newsGridView);
        newsList.add(new NewsItem("Báo Thanh Niên", R.drawable.thanhnien));
        newsList.add(new NewsItem("Báo VnExpress", R.drawable.vnexpress));
        newsList.add(new NewsItem("Báo Tin Tức", R.drawable.baotintuc));


        NewsAdapter newsAdapter = new NewsAdapter(this, R.layout.grid_news_item, newsList);
        gridView.setAdapter(newsAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent callShowCategories = new Intent(MainActivity.this, ShowCategories.class);
                Bundle myData = new Bundle();
                myData.putInt("News", position);
                myData.putString("Title", newsList.get(position).getNewsName());
                callShowCategories.putExtras(myData);
                startActivity(callShowCategories);
            }
        });
    }
}