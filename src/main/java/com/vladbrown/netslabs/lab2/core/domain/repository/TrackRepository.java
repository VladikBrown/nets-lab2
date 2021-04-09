package com.vladbrown.netslabs.lab2.core.domain.repository;

import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TrackRepository extends CrudRepository<Track, Long> {

    Optional<Track> findByName(String name);
}
