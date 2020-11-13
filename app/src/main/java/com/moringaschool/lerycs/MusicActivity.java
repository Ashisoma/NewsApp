package com.moringaschool.lerycs;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public class MusicActivity extends AppCompatActivity {


    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.songTextView) TextView mSongTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);
    }
}
