package com.moringaschool.news.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import com.moringaschool.news.R;
import com.moringaschool.news.models.Article;
import com.moringaschool.news.models.NewsSearchResponse;
import com.moringaschool.news.network.NewsApi;
import com.moringaschool.news.network.NewsClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.songTextView)
    TextView mSongTextView;

    private  String[] songName = new String[]{"hello", "jesus", "love", "better", "Live for you", "At the Center", "Come as you are", "we belong to you", "who am i", "Moyo wangu", "One day ata a time", "I can only imagine", "Wanna be happy"};
    private String [] artistName = new String[] {"Adele", "Ada", "hER", "hIM", "L.M.A.M","Houghton", "Crowder", "T-sharp", "hillsong", "Patrick Kibuya", "Bill Gaither", "Mercy me", "Kirk Franklyne"};


    public List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

//        MusicArrayAdapter adapter = new MusicArrayAdapter(this, android.R.layout.simple_list_item_1, songName, artistName);
//
//        mListView.setAdapter(adapter);
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String song = ((TextView)view).getText().toString();
//                Toast.makeText(ArticleListActivity.this, song, Toast.LENGTH_LONG).show();
//            }
//        });

        Intent intent = getIntent();
        String searchArticle = intent.getStringExtra("song");
//        mSongTextView.setText("Here are the songs available: " + searchArticle);

        NewsApi client = NewsClient.getClient();

        Call<NewsSearchResponse>  call = client.getArticles(searchArticle);

        call.enqueue(new Callback<NewsSearchResponse>() {
            @Override
            public void onResponse(Call<NewsSearchResponse> call, Response<NewsSearchResponse> response) {
                articles = response.body().getArticles();

            }

            @Override
            public void onFailure(Call<NewsSearchResponse> call, Throwable t) {

            }
        });
    }
}