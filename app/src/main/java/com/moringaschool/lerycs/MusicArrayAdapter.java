package com.moringaschool.lerycs;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class MusicArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mArtistsSong;
    private String [] mArtistName;

    public MusicArrayAdapter(Context mContext, int resource, String [] mArtistsSong, String [] mArtistName){
        super(mContext, resource);
        this.mArtistsSong = mArtistsSong;
        this.mContext = mContext;
        this.mArtistName = mArtistName;
    }

    @Override
    public Object getItem(int position) {
        String songName = mArtistsSong[position];
        String artistName = mArtistName[position];
        return  String.format("%s \nHit Song: %s", songName, artistName);
    }

    @Override
    public int getCount(){
        return mArtistsSong.length;
    }
}
