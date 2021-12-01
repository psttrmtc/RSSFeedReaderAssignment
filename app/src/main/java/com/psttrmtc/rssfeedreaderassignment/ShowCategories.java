package com.psttrmtc.rssfeedreaderassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShowCategories extends Activity {
    ArrayAdapter<String> adapterMainSubjects;
    int choosenNews;
    ListView myMainListView;
    Context context;
    RSSItem selectedNewsItem;
    String titleNews;
    TextView title;
    String[][][] myUrlCaptionMenu = {
        {// Thanh Nien News
                {"https://thanhnien.vn/rss/video-316.rss", "Video"},
                {"https://thanhnien.vn/rss/thoi-su-4.rss", "Thời sự"},
                {"https://thanhnien.vn/rss/toi-viet-89.rss","Tôi viết"},
                {"https://thanhnien.vn/rss/the-gioi-66.rss","Thế giới"},
                {"https://thanhnien.vn/rss/van-hoa-93.rss","Văn hóa"},
                {"https://thanhnien.vn/rss/giai-tri-285.rss","Giải trí"},
                {"https://thanhnien.vn/rss/the-thao-318.rss","Thể thao"},
                {"https://thanhnien.vn/rss/doi-song-17.rss","Đời sống"},
                {"https://thanhnien.vn/rss/tai-chinh-kinh-doanh-49.rss","Tài chính kinh doanh"},
                {"https://thanhnien.vn/rss/gioi-tre-69.rss","Giới trẻ"},
                {"https://thanhnien.vn/rss/giao-duc-26.rss","Giáo dục"},
                {"https://thanhnien.vn/rss/cong-nghe-12.rss","Công nghệ"},
                {"https://thanhnien.vn/rss/game-315.rss","Game"}

        },
            //VnExpress News
        {
                {"https://vnexpress.net/rss/the-gioi.rss", "Thế giới"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Thời sự"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Thời sự"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Kinh doanh"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Startup"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Giải trí"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Thể thao"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Pháp luật"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Giáo dục"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Tin mới nhất"},
                {"https://vnexpress.net/rss/thoi-su.rss", "Tin nổi bật"},
        },
        // Báo Tin Tức
            {
                    {"https://baotintuc.vn/tin-moi-nhat.rss", "Trang chủ"},
                    {"https://baotintuc.vn/thoi-su.rss", "Thời sự"},
                    {"https://baotintuc.vn/the-gioi.rss", "Thế Giới"},
                    {"https://baotintuc.vn/kinh-te.rss", "Kinh tế"},
                    {"https://baotintuc.vn/xa-hoi.rss", "Xã hội"},
                    {"https://baotintuc.vn/phap-luat.rss", "Pháp luật"},
                    {"https://baotintuc.vn/van-hoa.rss", "Văn hóa"},
                    {"https://baotintuc.vn/giao-duc.rss", "Giáo dục"},
                    {"https://baotintuc.vn/the-thao.rss", "Thể thao"},
                    {"https://baotintuc.vn/ho-so.rss", "Hồ sơ"},
                    {"https://baotintuc.vn/quan-su.rss", "Quân sự"},
                    {"https://baotintuc.vn/khoa-hoc-cong-nghe.rss", "Khoa học - công nghệ"},
                    {"https://baotintuc.vn/bien-dao-viet-nam.rss", "Biển đảo"},
                    {"https://baotintuc.vn/suc-khoe.rss", "Sức khỏe"},
                    {"https://baotintuc.vn/dia-phuong.rss", "Địa phương"},
                    {"https://baotintuc.vn/video.rss", "Video"},
                    {"https://baotintuc.vn/anh.rss", "Ảnh"},
                    {"https://baotintuc.vn/emagazine.rss", "Infographic"},
                    {"https://baotintuc.vn/ban-doc.rss", "Bạn đọc"},
                    {"https://baotintuc.vn/anh-360.rss", "Ảnh 360"},

            }
    };
    String[] myUrlCaption ;
    String[] myUrlAddress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_categories);
        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        choosenNews = myBundle.getInt("News");
        titleNews = myBundle.getString("Title");
        title = findViewById(R.id.txtTitle);
        title.setText("Chanels in " + titleNews);


        myUrlCaption = new String[myUrlCaptionMenu[choosenNews].length];
        myUrlAddress = new String[myUrlCaptionMenu[choosenNews].length];
        for (int i = 0; i < myUrlCaptionMenu[choosenNews].length; i++){
            myUrlAddress[i] = myUrlCaptionMenu[choosenNews][i][0];
            myUrlCaption[i] = myUrlCaptionMenu[choosenNews][i][1];
        }
        context = getApplicationContext();

        myMainListView = (ListView) this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int _index, long _id) {
                String urlAddress = myUrlAddress[_index], urlCaption = myUrlCaption[_index];
                Intent callShowHeadLines = new Intent(getApplicationContext(), ShowHeadlines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                myData.putString("News", titleNews);
                callShowHeadLines.putExtras(myData);
                startActivity(callShowHeadLines);
            }
        });
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }
}