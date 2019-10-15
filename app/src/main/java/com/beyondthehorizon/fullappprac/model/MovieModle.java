package com.beyondthehorizon.fullappprac.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.beyondthehorizon.fullappprac.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movie_table")
public class MovieModle {

        @SerializedName("id")
        @PrimaryKey(autoGenerate = false)
        long id;

        @SerializedName("poster_path")
        @ColumnInfo(name = "poster_path")
        String imageUrl;
        @SerializedName("original_title")
        String title;
        @SerializedName("vote_average")
        String ratings;
        @SerializedName("overview")
        String description;
        @SerializedName("release_date")
        String release_date;

        public MovieModle(long id, String imageUrl, String title, String ratings, String description, String release_date) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.title = title;
            this.ratings = ratings;
            this.description = description;
            this.release_date = release_date;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRatings() {
            return ratings;
        }

        public void setRatings(String ratings) {
            this.ratings = ratings;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        @BindingAdapter("picha")
        public static void loadImages(ImageView view, String imageUrl){
            String imageRl = "https://image.tmdb.org/t/p/w185/"+imageUrl;
            Glide.with(view.getContext())
                    .setDefaultRequestOptions(new RequestOptions()
                            .circleCrop())
                    .load(imageRl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(view);
        }
    }

