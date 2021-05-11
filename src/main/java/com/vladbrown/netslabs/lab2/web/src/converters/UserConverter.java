package com.vladbrown.netslabs.lab2.web.src.converters;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.web.src.dto.AlbumData;
import com.vladbrown.netslabs.lab2.web.src.dto.ArtistData;
import com.vladbrown.netslabs.lab2.web.src.dto.TrackData;
import com.vladbrown.netslabs.lab2.web.src.dto.UserData;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter implements Converter<User, UserData> {


    @Override
    public UserData convert(User user) {
        var userData = new UserData();
        return convert(user, userData);
    }

    @Override
    public UserData convert(User user, UserData userData) {
        userData.setId(user.getId());
        userData.setFirstName(user.getFirstName());
        userData.setSecondName(user.getSecondName());
        userData.setUserName(user.getUserName());

        var artistsData = new LinkedList<ArtistData>();
        for (var artist : user.getLikedArtists()) {
            var artistData = new ArtistData();
            artistData.setId(artist.getId());
            artistData.setName(artist.getName());
            artistData.setDescription(artist.getDescription());
            artistsData.add(artistData);
        }
        userData.setLikedArtists(artistsData);

        var albumsData = new LinkedList<AlbumData>();
        for (var album : user.getLikedAlbums()) {
            var albumData = new AlbumData();
            albumData.setId(album.getId());
            albumData.setReleaseDate(album.getReleaseDate());
            albumData.setName(album.getName());
            albumData.setDescription(album.getDescription());
            albumsData.add(albumData);
        }
        userData.setLikedAlbums(albumsData);

        var tracksData = new LinkedList<TrackData>();
        for (var track : user.getLikedTracks()) {
            var trackData = new TrackData();
            trackData.setId(track.getId());
            trackData.setName(track.getName());
            trackData.setSingle(
                    trackData.getSingle() != null
                            ? trackData.getSingle() : false);
            var artistData = new ArtistData();
            artistData.setId(track.getAlbum().getArtist().getId());
            artistData.setName(track.getAlbum().getArtist().getName());

            var albumData = new AlbumData();
            albumData.setId(track.getAlbum().getId());
            albumData.setName(track.getAlbum().getName());
            albumData.setArtist(artistData);
            trackData.setAlbum(albumData);
            tracksData.add(trackData);
        }
        userData.setLikedTracks(tracksData);

        return userData;
    }

    @Override
    public List<UserData> convertAll (List<User> users) {
        return users.stream().map(this::convert).collect(Collectors.toList());
    }
}
