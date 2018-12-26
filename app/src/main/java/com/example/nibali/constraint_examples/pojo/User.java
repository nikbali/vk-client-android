package com.example.nibali.constraint_examples.pojo;

import android.support.annotation.NonNull;

import com.google.common.base.*;

public class User {
    private long id;
    private String imageUrl;
    private String name;
    private String nick;
    private String description;
    private String location;
    private int followingCount;
    private int followersCount;

    public User(){}
    public User(long id,
                String imageUrl,
                String name,
                String nick,
                String description,
                String location,
                int followingCount,
                int followersCount) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.nick = nick;
        this.description = description;
        this.location = location;
        this.followingCount = followingCount;
        this.followersCount = followersCount;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", followingCount=" + followingCount +
                ", followersCount=" + followersCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return followingCount == user.followingCount &&
                followersCount == user.followersCount &&
                Objects.equal(imageUrl, user.imageUrl) &&
                Objects.equal(name, user.name) &&
                Objects.equal(nick, user.nick) &&
                Objects.equal(description, user.description) &&
                Objects.equal(location, user.location);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imageUrl, name, nick, description, location, followingCount, followersCount);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }
}
