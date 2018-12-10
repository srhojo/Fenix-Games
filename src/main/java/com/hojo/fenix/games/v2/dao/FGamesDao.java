package com.hojo.fenix.games.v2.dao;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public interface FGamesDao<S> {

    S save(@Valid S s);

    S update(@Valid S s);

    List<S> retrieveAll();

    void delete(Integer id);

    default List<S> save(@Valid List<S> list) {
        return list.stream().map(this::save).collect(Collectors.toList());
    }

    default List<S> udpate(@Valid List<S> list) {
        return list.stream().map(this::update).collect(Collectors.toList());
    }

}
