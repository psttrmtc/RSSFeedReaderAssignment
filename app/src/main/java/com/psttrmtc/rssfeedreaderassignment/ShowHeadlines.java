package com.psttrmtc.rssfeedreaderassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowHeadlines extends Activity {

    ArrayList<RSSItem> newsList = new ArrayList<RSSItem>();
    ListView myListView;
    String urlAddress = "";
    String urlCaption = "";
    RSSItem selectedNews;
    String titleNews;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_headlines);
        myListView = (ListView) this.findViewById(R.id.myListView);
        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        urlAddress = myBundle.getString("urlAddress");
        urlCaption = myBundle.getString("urlCaption");
        titleNews = myBundle.getString("News");
        title = findViewById(R.id.txtTitle);
        title.setText("Item in chanel " + urlCaption + " - " + titleNews);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                selectedNews = newsList.get(index);
                showNiceDialogBox(selectedNews, getApplicationContext());
            }
        });
        DownloadRssFeed downloader = new DownloadRssFeed(ShowHeadlines.this);
        downloader.execute(urlAddress, urlCaption);
    }
    public void showNiceDialogBox(RSSItem selectedStoryItem, Context context){
        String title = selectedStoryItem.getTitle();
        String description = selectedStoryItem.getDescription();
        if (title.toLowerCase().equals(description.toLowerCase())){
            description = "";
        }
        try {

            final Uri storyLink = Uri.parse(selectedStoryItem.getLink());
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder.setTitle(Html.fromHtml(urlCaption) )
                    .setMessage(title + "\n\n"+ Html.fromHtml(description) + "\n").setPositiveButton("Close", null)
                    .setNegativeButton("More", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichOne) {
                            Intent browser = new Intent(Intent.ACTION_VIEW, storyLink);
                            startActivity(browser);
                        }}) //setNegativeButton
                    .show();
        }
        catch (Exception e) { Log.e("Error DialogBox", e.getMessage() ); }
    }//
}