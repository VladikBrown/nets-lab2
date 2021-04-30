package com.vladbrown.netslabs.lab2.core.service.impl;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.domain.repository.AlbumRepository;
import com.vladbrown.netslabs.lab2.core.domain.repository.ArtistRepository;
import com.vladbrown.netslabs.lab2.core.domain.repository.UserRepository;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultArtistService implements ArtistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).get();
    }

    @Override
    public List<Artist> findAll() {
        return (List<Artist>) artistRepository.findAll();
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public void addNewAlbum(String artistId, Album album) {
        var artist = artistRepository.findById(Long.valueOf(artistId)).get();
        album.setArtist(artist);
        var savedAlbum = albumRepository.save(album);
        artist.getAlbums().add(savedAlbum);
        artistRepository.save(artist);
    }

    @Override
    public void likeArtistByUsername(String userName, Long artistId) {
        var user = userRepository.findByUserName(userName).get();
        var artist = artistRepository.findById(artistId).get();

        likeArtist(user, artist);
    }

    @Override
    public void likeArtistByUserId(Long userId, Long artistId) {
        var user = userRepository.findById(userId).get();
        var artist = artistRepository.findById(artistId).get();

        likeArtist(user, artist);
    }

    private void likeArtist(User user, Artist artist) {
        user.getLikedArtists().add(artist);
        artist.getLikes().add(user);

        userRepository.save(user);
        artistRepository.save(artist);
    }
}
