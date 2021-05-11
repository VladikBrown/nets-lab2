package com.vladbrown.netslabs.lab2.web.src.dto;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;

import java.util.Set;

public class ArtistData {

    private Long id;

    private String name;

    private String description;

    private Set<AlbumData> albums;

    private Set<UserData> likes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AlbumData> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<AlbumData> albums) {
        this.albums = albums;
    }

    public Set<UserData> getLikes() {
        return likes;
    }

    public void setLikes(Set<UserData> likes) {
        this.likes = likes;
    }
}
