package com.vladbrown.netslabs.lab2.core.service.impl;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.domain.repository.AlbumRepository;
import com.vladbrown.netslabs.lab2.core.domain.repository.TrackRepository;
import com.vladbrown.netslabs.lab2.core.domain.repository.UserRepository;
import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAlbumService implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).get();
    }

    @Override
    public List<Album> findAll() {
        return (List<Album>) albumRepository.findAll();
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public void addNewTrack(String albumId, Track track) {
        var album = albumRepository.findById(Long.valueOf(albumId)).get();
        track.setAlbum(album);
        var savedTrack = trackRepository.save(track);
        album.getTracks().add(savedTrack);
        albumRepository.save(album);
    }

    @Override
    public void likeAlbumByUsername(String userName, Long albumId) {
        var user = userRepository.findByUserName(userName).get();
        var album = albumRepository.findById(albumId).get();

        likeAlbum(user, album);
    }

    private void likeAlbum(User user, Album album) {
        user.getLikedAlbums().add(album);
        album.getLikes().add(user);

        userRepository.save(user);
        albumRepository.save(album);
    }
}
