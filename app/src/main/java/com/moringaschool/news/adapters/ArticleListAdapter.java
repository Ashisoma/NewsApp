package com.moringaschool.news.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.news.R;
import com.moringaschool.news.models.Article;
import com.moringaschool.news.ui.ArticleDetailActivity;
import com.moringaschool.news.ui.ArticleListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {
    private List<Article> mArticle;
    private Context mContext;

    public ArticleListAdapter(List<Article> article, Context context) {
        this.mArticle = article;
        this.mContext = context;
    }

    @Override
    public ArticleListAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list_item, parent, false);
        ArticleViewHolder viewHolder = new ArticleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( @NonNull  ArticleListAdapter.ArticleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        mArticle.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.articleImageView) ImageView mArticleImageView;
        @BindView(R.id.articleNameTextView) TextView mArticleNameTextView;
        @BindView(R.id.publishedAtTextView) TextView mPublishedAt;
        @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
        private Context context;

        public ArticleViewHolder (View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getAdapterPosition();
            Intent intent = new Intent(mContext, ArticleDetailActivity.class);
        }
    }


}
