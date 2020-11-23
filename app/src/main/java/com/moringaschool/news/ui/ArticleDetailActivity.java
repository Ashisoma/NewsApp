package com.moringaschool.news.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcel;

import com.moringaschool.news.R;
import com.moringaschool.news.adapters.ArticlePagerAdapter;
import com.moringaschool.news.models.Article;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private List<Article> mArticles;
    private ArticlePagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);


        mArticles = Parcels.unwrap(getIntent().getParcelableExtra("q"));
        int startPosition = getIntent().getIntExtra("position",0);

        adapterViewPager = new ArticlePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mArticles);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startPosition);
    }
}