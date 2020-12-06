package com.moringaschool.news.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.news.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findSongText) EditText mFindSongText;
    @BindView(R.id.searchArticle) Button mSearchArticleButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
//    @BindView(R.id.searchArticle) Button mGetArtistsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mSearchArticleButton.setOnClickListener(this);
//        mGetArtistsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if(view == mSearchArticleButton) {
            Intent intent = new Intent(MainActivity.this, ArticleListActivity.class);
            String search = mFindSongText.getText().toString();
            intent.putExtra("q", search);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slight_out_left);
        }
//        }else if(view == mGetArtistsButton){
//            Intent intent = new Intent(MainActivity.this, ArtistsListActivity.class);
//            startActivity(intent);
//        }
    }
}
