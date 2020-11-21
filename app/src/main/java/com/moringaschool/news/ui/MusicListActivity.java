package com.moringaschool.news.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.news.adapters.MusicArrayAdapter;
import com.moringaschool.news.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicListActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.songTextView)
    TextView mSongTextView;

    private  String[] songName = new String[]{"hello", "jesus", "love", "better", "Live for you", "At the Center", "Come as you are", "we belong to you", "who am i", "Moyo wangu", "One day ata a time", "I can only imagine", "Wanna be happy"};
    private String [] artistName = new String[] {"Adele", "Ada", "hER", "hIM", "L.M.A.M","Houghton", "Crowder", "T-sharp", "hillsong", "Patrick Kibuya", "Bill Gaither", "Mercy me", "Kirk Franklyne"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        ButterKnife.bind(this);


        MusicArrayAdapter adapter = new MusicArrayAdapter(this, android.R.layout.simple_list_item_1, songName, artistName);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song = ((TextView)view).getText().toString();
                Toast.makeText(MusicListActivity.this, song, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String nameSong = intent.getStringExtra("song");
        mSongTextView.setText("Here are the songs available: " + nameSong);
    }
}