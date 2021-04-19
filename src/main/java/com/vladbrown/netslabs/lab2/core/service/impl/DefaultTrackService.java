package com.vladbrown.netslabs.lab2.core.service.impl;

import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.domain.repository.TrackRepository;
import com.vladbrown.netslabs.lab2.core.domain.repository.UserRepository;
import com.vladbrown.netslabs.lab2.core.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTrackService implements TrackService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id).get();
    }

    @Override
    public List<Track> findAll() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Track save(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public void deleteById(Long id) {
        trackRepository.deleteById(id);
    }

    @Override
    public void likeTrackByUsername(String userName, Long trackId) {
        var user = userRepository.findByUserName(userName).get();
        var track = trackRepository.findById(trackId).get();

        likeTrack(user, track);
    }

    private void likeTrack(User user, Track track) {
        user.getLikedTracks().add(track);
        track.getLikes().add(user);

        userRepository.save(user);
        trackRepository.save(track);
    }
}
