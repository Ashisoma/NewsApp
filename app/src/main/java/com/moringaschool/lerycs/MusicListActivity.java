package com.moringaschool.lerycs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicListActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.songTextView)
    TextView mSongTextView;

    private  String[] songName = new String[]{"hello", "jesus", "love", "better"};
    private String [] artistName = new String[] {"Adele", "Ada", "hER", "hIM"};


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