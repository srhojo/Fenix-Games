package com.hojo.fenix.games.v2.dao.impl;

import com.hojo.fenix.games.v2.dao.GameDao;
import com.hojo.fenix.games.v2.dao.repository.GameRepository;
import com.hojo.fenix.games.v2.domain.entity.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;


@Repository
@Transactional
public class GameDaoImpl implements GameDao {

    private final GameRepository gameRepository;

    @Autowired
    public GameDaoImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameEntity save(@Valid GameEntity game) {
        game.setId(null);
        return gameRepository.save(game);
    }

    @Override
    public GameEntity update(@Valid GameEntity game) {
        return gameRepository.findById(game.getId()).map(gameEntity -> {
            gameEntity.setName(game.getName());
            gameEntity.setDescription(game.getDescription());
            return gameRepository.save(gameEntity);
        }).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public List<GameEntity> retrieveAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        gameRepository.deleteById(id);
    }
}
