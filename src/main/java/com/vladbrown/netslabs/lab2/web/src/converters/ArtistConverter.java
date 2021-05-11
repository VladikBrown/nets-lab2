package com.vladbrown.netslabs.lab2.web.src.converters;

import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.web.src.dto.AlbumData;
import com.vladbrown.netslabs.lab2.web.src.dto.ArtistData;
import com.vladbrown.netslabs.lab2.web.src.dto.TrackData;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistConverter implements Converter<Artist, ArtistData> {

    @Override
    public ArtistData convert(Artist artist) {
        return convert(artist, new ArtistData());
    }

    @Override
    public ArtistData convert(Artist artist, ArtistData artistData) {
        artistData.setId(artist.getId());
        artistData.setName(artist.getName());
        artistData.setDescription(artist.getDescription());

        var albumsData = new HashSet<AlbumData>();
        for (var album : artist.getAlbums()) {
            var albumData = new AlbumData();
            albumData.setId(album.getId());
            albumData.setName(album.getName());

            var artistDataForAlbum = new ArtistData();
            artistDataForAlbum.setId(artist.getId());
            artistDataForAlbum.setName(artist.getName());
            artistDataForAlbum.setDescription(artist.getDescription());
            albumData.setArtist(artistDataForAlbum);

            var tracksData = new HashSet<TrackData>();
            for (var track : album.getTracks()) {
                var trackData = new TrackData();
                trackData.setId(track.getId());
                trackData.setName(track.getName());
                trackData.setSingle(
                        trackData.getSingle() != null
                                ? trackData.getSingle() : false);

                var albumDataForTrack = new AlbumData();
                albumDataForTrack.setId(album.getId());
                albumDataForTrack.setName(album.getName());
                albumDataForTrack.setArtist(artistDataForAlbum);

                trackData.setAlbum(albumDataForTrack);
                tracksData.add(trackData);
            }
            albumData.setTracks(tracksData);
            albumsData.add(albumData);
        }
        artistData.setAlbums(albumsData);
        return artistData;
    }

    @Override
    public List<ArtistData> convertAll(List<Artist> artists) {
        return artists.stream().map(this::convert).collect(Collectors.toList());
    }
}
