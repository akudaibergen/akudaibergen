package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;

    @SerializedName("genre_ids")
    private List<Integer> genre_ids=new ArrayList<Integer>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;

    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private String vote_count;
    @SerializedName("video")
    private Boolean video;
    @SerializedName("vote_average")
    private Double vote_average;


    public Movie(String posterPath, boolean adult, String overview,
                 String release_date, List<Integer> genre_ids, Integer id,
                 String original_title, String original_language, String title,
                 String backdrop_path, Double popularity, String vote_count,
                 Boolean video, Double vote_average) {
        this.posterPath = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.vote_average = vote_average;
    }

    String baseImageUrl="https://image.tmdb.org/t/p/w500";

    public String getPosterPath() {
        return baseImageUrl+posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }
}
