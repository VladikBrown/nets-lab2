package com.vladbrown.netslabs.lab2.core.service;

import com.vladbrown.netslabs.lab2.core.domain.entity.Track;

public interface TrackService extends PlainDataService<Track, Long> {

    void likeTrackByUsername(String userName, Long trackId);

    void likeTrackByUserId(Long userId, Long trackId);
}
