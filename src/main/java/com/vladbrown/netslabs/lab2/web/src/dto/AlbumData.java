package com.vladbrown.netslabs.lab2.web.src.dto;

import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;

import java.util.Set;

public class AlbumData {

    private Long id;

    private String name;

    private String description;

    private String releaseDate;

    private Set<TrackData> tracks;

    private ArtistData artist;

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<TrackData> getTracks() {
        return tracks;
    }

    public void setTracks(Set<TrackData> tracks) {
        this.tracks = tracks;
    }

    public ArtistData getArtist() {
        return artist;
    }

    public void setArtist(ArtistData artist) {
        this.artist = artist;
    }

    public Set<UserData> getLikes() {
        return likes;
    }

    public void setLikes(Set<UserData> likes) {
        this.likes = likes;
    }
}
