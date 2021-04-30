package com.vladbrown.netslabs.lab2.core.service;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Track;

public interface AlbumService extends PlainDataService<Album, Long> {

    void addNewTrack(String albumId, Track track);

    void likeAlbumByUsername(String userName, Long albumId);

    void likeAlbumByUserId(Long userId, Long albumId);
}
