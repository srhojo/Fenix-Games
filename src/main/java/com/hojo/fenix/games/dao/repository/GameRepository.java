package com.hojo.fenix.games.dao.repository;

import com.hojo.fenix.games.domain.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<GameEntity,Integer> {

    List<GameEntity> findAll();
}
