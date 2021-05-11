package com.vladbrown.netslabs.lab2.web.src.dto;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;

import java.util.Set;

public class TrackData {

    private Long id;

    private String name;

    private Boolean isSingle;

    private AlbumData album;

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

    public Boolean getSingle() {
        return isSingle;
    }

    public void setSingle(Boolean single) {
        isSingle = single;
    }

    public AlbumData getAlbum() {
        return album;
    }

    public void setAlbum(AlbumData album) {
        this.album = album;
    }

    public Set<UserData> getLikes() {
        return likes;
    }

    public void setLikes(Set<UserData> likes) {
        this.likes = likes;
    }
}
