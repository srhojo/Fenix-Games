package com.hojo.fenix.games.service;

import com.hojo.fenix.games.domain.Games;
import com.hojo.fenix.games.domain.Players;
import com.hojo.fenix.games.domain.entity.GameEntity;
import com.hojo.fenix.games.domain.entity.PlayerEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public interface GamesAdminServices {

    PlayerEntity savePlayer(@Valid PlayerEntity player);

    Players retrieveAllPlayers();

    void deletePlayer(@NotEmpty Integer id);

    GameEntity saveGame(@Valid GameEntity game);

    Games retrieveAllGames();

    void deleteGame(@NotEmpty Integer id);

}
