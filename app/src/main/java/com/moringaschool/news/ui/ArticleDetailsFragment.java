package com.moringaschool.news.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.news.R;
import com.moringaschool.news.models.Article;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleDetailsFragment extends Fragment {

    @BindView(R.id.articleImageView) ImageView mImageLabel;
    @BindView(R.id.articleNameTextView) TextView mArticleNameLabel;
    @BindView(R.id.articleAuthorTextView) TextView mAuthorLabel;
    @BindView(R.id.descriptionTextView) TextView mArticleDescriptionLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;


    private Article mArticle;

    public ArticleDetailsFragment() {
        // Required empty public constructor
    }

    public static ArticleDetailsFragment newInstance(Article article) {
        ArticleDetailsFragment fragment = new ArticleDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("q", Parcels.wrap(article));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArticle = Parcels.unwrap(getArguments().getParcelable("q"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_article_details, container, false);
        View view = inflater.inflate(R.layout.fragment_article_details, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mArticle.getUrlToImage()).into(mImageLabel);
        mArticleNameLabel.setText(mArticle.getTitle());
        mAuthorLabel.setText(mArticle.getAuthor());
        mArticleDescriptionLabel.setText(mArticle.getContent());


        return view;
    }


    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mArticle.getUrl()));
            startActivity(webIntent);
        }
    }
}