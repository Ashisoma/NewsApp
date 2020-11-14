package com.moringaschool.lerycs;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicActivity extends AppCompatActivity {


    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.songTextView) TextView mSongTextView;

    private  String[] songName = new String[]{"hello", "jesus", "love", "better"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);
        ButterKnife.bind(this);



    }
}
