package com.hojo.fenix.games.v2.service.impl;

import com.hojo.fenix.games.v2.dao.GameDao;
import com.hojo.fenix.games.v2.dao.PlayerDao;
import com.hojo.fenix.games.v2.domain.Games;
import com.hojo.fenix.games.v2.domain.Players;
import com.hojo.fenix.games.v2.domain.entity.GameEntity;
import com.hojo.fenix.games.v2.domain.entity.PlayerEntity;
import com.hojo.fenix.games.v2.service.GamesAdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Service
public class GamesAdminServiceImpl implements GamesAdminServices {

    private final PlayerDao playerDao;
    private final GameDao gameDao;

    @Autowired
    public GamesAdminServiceImpl(PlayerDao playerDao, GameDao gameDao) {
        this.playerDao = playerDao;
        this.gameDao = gameDao;
    }

    @Override
    public PlayerEntity savePlayer(@Valid PlayerEntity player) {
        return (player.getId() != null) ? playerDao.update(player) : playerDao.save(player);
    }

    @Override
    public Players retrieveAllPlayers() {
        Players players = new Players();
        players.setPlayers(playerDao.retrieveAll());
        return players;
    }

    @Override
    public void deletePlayer(@NotEmpty Integer id) {
        playerDao.delete(id);
    }

    @Override
    public GameEntity saveGame(@Valid GameEntity game) {
        return game.getId() != null ? gameDao.update(game) : gameDao.save(game);
    }

    @Override
    public Games retrieveAllGames() {
        Games games = new Games();
        games.setGames(gameDao.retrieveAll());
        return games;
    }

    @Override
    public void deleteGame(@NotEmpty Integer id) {
        gameDao.delete(id);
    }
}
