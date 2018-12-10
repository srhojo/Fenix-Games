package com.hojo.fenix.games.v2.dao.repository;

import com.hojo.fenix.games.v2.domain.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<GameEntity,Integer> {

    List<GameEntity> findAll();
}
