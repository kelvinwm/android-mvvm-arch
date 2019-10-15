package com.beyondthehorizon.fullappprac.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDbResponse {
    @SerializedName("page")
    int page;
    @SerializedName("total_results")
    int total_results;
    @SerializedName("total_pages")
    int total_pages;
    @SerializedName("results")
    List<MovieModle> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieModle> getResults() {
        return results;
    }

    public void setResults(List<MovieModle> results) {
        this.results = results;
    }
}
