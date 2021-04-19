package com.vladbrown.netslabs.lab2.web.src.dto;

import java.util.List;

public class UserData {

    private String firstName;

    private String secondName;

    private String nickname;

    private List<ArtistData> likedArtists;

    private List<AlbumData> likedAlbums;

    private List<TrackData> trackData;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public List<TrackData> getTrackData() {
        return trackData;
    }

    public void setTrackData(List<TrackData> trackData) {
        this.trackData = trackData;
    }
}
