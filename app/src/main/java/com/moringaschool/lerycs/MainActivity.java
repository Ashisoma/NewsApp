package com.moringaschool.lerycs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findSongText) EditText mFindSongText;
    @BindView(R.id.searchLyrics) Button mSearchLyricsButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.getArtists) Button mGetArtistsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchLyricsButton.setOnClickListener(this);
        mGetArtistsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if(view == mSearchLyricsButton) {
            Intent intent = new Intent(MainActivity.this, MusicListActivity.class);
            String song = mFindSongText.getText().toString();
            intent.putExtra("song", song);
            startActivity(intent);
        }else (view == mGetArtistsButton){
            Intent intent = new Intent(MainActivity.this, MusicListActivity.class);
            startActivity(intent);
        }
    }
}
