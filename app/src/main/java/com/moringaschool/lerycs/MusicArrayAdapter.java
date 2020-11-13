package com.moringaschool.lerycs;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class MusicArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mArtistsSong;

    public MusicArrayAdapter(Context mContext, int resource, String [] mArtistsSong){
        super(mContext, resource);
        this.mArtistsSong = mArtistsSong;
        this.mContext = mContext;
    }

    @Override
    public Object getItem(int position) {
        String songName = mArtistsSong[position];
        return  String.format("%s \nServes great: %s", songName);
    }

    @Override
    public int getCount(){
        return mArtistsSong.length;
    }
}
