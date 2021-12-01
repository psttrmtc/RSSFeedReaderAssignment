package com.psttrmtc.rssfeedreaderassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter {

    ArrayList<NewsItem> newsList = new ArrayList<>();
    public NewsAdapter(@NonNull Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        newsList = objects;
    }



    @Override
    public int getCount() {
        return super.getCount();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_news_item,null);
        ImageView imageView = (ImageView)  v.findViewById(R.id.imageView);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(newsList.get(position).getNewsName());
        imageView.setImageResource(newsList.get(position).getNewsImage());
        return v;
    }
}
