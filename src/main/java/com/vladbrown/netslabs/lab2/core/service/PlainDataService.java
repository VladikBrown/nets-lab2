package com.vladbrown.netslabs.lab2.core.service;

import java.util.List;

public interface PlainDataService<T, P> {

    T findById(P id);

    List<T> findAll();

    T save(T t);

    void deleteById(P id);
}
