        package com.moringaschool.news.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.news.models.Article;
import com.moringaschool.news.ui.ArticleDetailsFragment;

import java.util.List;

public class  ArticlePagerAdapter extends FragmentPagerAdapter {

    private List<Article> mArticles;

    public ArticlePagerAdapter(FragmentManager fm, int behavior, List<Article> mArticles) {
        super(fm, behavior);
        this.mArticles = mArticles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ArticleDetailsFragment.newInstance(mArticles.get(position));
    }

    @Override
    public int getCount() {
        return mArticles.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mArticles.get(position).getTitle();
    }
}
