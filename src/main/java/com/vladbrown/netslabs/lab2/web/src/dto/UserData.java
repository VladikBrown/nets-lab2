package com.vladbrown.netslabs.lab2.web.src.dto;

import java.util.List;

public class UserData {

    private Long id;

    private String firstName;

    private String secondName;

    private String userName;

    private List<ArtistData> likedArtists;

    private List<AlbumData> likedAlbums;

    private List<TrackData> likedTracks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String nickname) {
        this.userName = nickname;
    }

    public List<ArtistData> getLikedArtists() {
        return likedArtists;
    }

    public void setLikedArtists(List<ArtistData> likedArtists) {
        this.likedArtists = likedArtists;
    }

    public List<AlbumData> getLikedAlbums() {
        return likedAlbums;
    }

    public void setLikedAlbums(List<AlbumData> likedAlbums) {
        this.likedAlbums = likedAlbums;
    }

    public List<TrackData> getLikedTracks() {
        return likedTracks;
    }

    public void setLikedTracks(List<TrackData> likedTracks) {
        this.likedTracks = likedTracks;
    }
}
