package com.example.nibali.constraint_examples.pojo;

import com.google.common.base.Objects;

public class Post {
    private User user;
    private Long id;
    private String creationDate;
    private String text;
    private Long retweetCount;
    private Long favouriteCount;
    private String imageUrl;

    public Post(User user,
                Long id,
                String creationDate,
                String text,
                Long retweetCount,
                Long favouriteCount,
                String imageUrl) {
        this.user = user;
        this.id = id;
        this.creationDate = creationDate;
        this.text = text;
        this.retweetCount = retweetCount;
        this.favouriteCount = favouriteCount;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user=" + user +
                ", id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", text='" + text + '\'' +
                ", retweetCount=" + retweetCount +
                ", favouriteCount=" + favouriteCount +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equal(user, post.user) &&
                Objects.equal(creationDate, post.creationDate) &&
                Objects.equal(text, post.text) &&
                Objects.equal(retweetCount, post.retweetCount) &&
                Objects.equal(favouriteCount, post.favouriteCount) &&
                Objects.equal(imageUrl, post.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user, creationDate, text, retweetCount, favouriteCount, imageUrl);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Long getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(Long favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
