package com.moringaschool.lerycs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicListActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.songTextView)
    TextView mSongTextView;

    private  String[] songName = new String[]{"hello", "jesus", "love", "better"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        ButterKnife.bind(this);


        MusicArrayAdapter adapter = new MusicArrayAdapter(this, android.R.layout.simple_list_item_1, songName);

        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String song = intent.getStringExtra("song");
        mSongTextView.setText("Here are the songs available: " + song);
    }
}