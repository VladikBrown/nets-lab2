package com.vladbrown.netslabs.lab2.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "username")
    private String userName;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "user2track",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Set<Track> likedTracks;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "user2album",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> likedAlbums;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "user2artist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> likedArtists;

    public User() {
    }

    public User(Long id, String firstName, String secondName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
    }

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Album> getLikedAlbums() {
        return likedAlbums;
    }

    public void setLikedAlbums(Set<Album> likedAlbums) {
        this.likedAlbums = likedAlbums;
    }

    public Set<Track> getLikedTracks() {
        return likedTracks;
    }

    public void setLikedTracks(Set<Track> likedTracks) {
        this.likedTracks = likedTracks;
    }

    public Set<Artist> getLikedArtists() {
        return likedArtists;
    }

    public void setLikedArtists(Set<Artist> likedArtists) {
        this.likedArtists = likedArtists;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", userName='" + userName + '\'' +
                ", likedTracks=" + likedTracks +
                ", likedAlbums=" + likedAlbums +
                ", likedArtists=" + likedArtists +
                '}';
    }
}
