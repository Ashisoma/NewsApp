package com.moringaschool.lerycs.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("artist")
    @Expose
    private Artist artist;
    @SerializedName("track")
    @Expose
    private Track track;
    @SerializedName("copyright")
    @Expose
    private Copyright copyright;
    @SerializedName("probability")
    @Expose
    private Long probability;
    @SerializedName("similarity")
    @Expose
    private Long similarity;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param copyright
     * @param artist
     * @param probability
     * @param similarity
     * @param track
     */
    public Result(Artist artist, Track track, Copyright copyright, Long probability, Long similarity) {
        super();
        this.artist = artist;
        this.track = track;
        this.copyright = copyright;
        this.probability = probability;
        this.similarity = similarity;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public Long getProbability() {
        return probability;
    }

    public void setProbability(Long probability) {
        this.probability = probability;
    }

    public Long getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Long similarity) {
        this.similarity = similarity;
    }

}
