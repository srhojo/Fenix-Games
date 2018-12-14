package com.hojo.fenix.games.dao.repository;

import com.hojo.fenix.games.domain.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<PlayerEntity,Integer> {

    List<PlayerEntity> findAll();
}
