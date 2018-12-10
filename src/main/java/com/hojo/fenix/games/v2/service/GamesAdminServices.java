package com.hojo.fenix.games.v2.service;

import com.hojo.fenix.games.v2.domain.Games;
import com.hojo.fenix.games.v2.domain.Players;
import com.hojo.fenix.games.v2.domain.entity.GameEntity;
import com.hojo.fenix.games.v2.domain.entity.PlayerEntity;

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
