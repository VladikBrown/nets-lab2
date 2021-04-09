package com.vladbrown.netslabs.lab2.core.domain.repository;

import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

    Optional<Artist> findByName(String name);
}
