package com.vladbrown.netslabs.lab2.core.domain.repository;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    Optional<Album> findByName(String name);
}
