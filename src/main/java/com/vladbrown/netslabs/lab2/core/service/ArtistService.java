package com.vladbrown.netslabs.lab2.core.service;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;

public interface ArtistService extends PlainDataService<Artist, Long> {

    void addNewAlbum(String artistId, Album album);

    void likeArtistByUsername(String userName, Long artistId);

    void likeArtistByUserId(Long userId, Long artistId);
}
