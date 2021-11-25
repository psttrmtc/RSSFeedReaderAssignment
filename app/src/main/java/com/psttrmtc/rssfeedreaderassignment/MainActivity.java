package com.psttrmtc.rssfeedreaderassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    ImageButton btnThanhNien;
    ImageButton btnVnExpress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThanhNien = findViewById(R.id.btnThanhNien);
        btnVnExpress = findViewById(R.id.btnVnExpress);

        btnVnExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callShowCategories = new Intent(MainActivity.this, ShowCategories.class);
                Bundle myData = new Bundle();
                myData.putInt("News", 1);
                myData.putString("Title", "VnExpress");
                callShowCategories.putExtras(myData);
                startActivity(callShowCategories);
            }
        });
        btnThanhNien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callShowCategories = new Intent(MainActivity.this, ShowCategories.class);
                Bundle myData = new Bundle();
                myData.putInt("News", 0);
                myData.putString("Title", "Thanh Niên");
                callShowCategories.putExtras(myData);
                startActivity(callShowCategories);
            }
        });
    }
}