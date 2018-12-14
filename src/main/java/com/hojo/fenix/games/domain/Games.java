package com.hojo.fenix.games.domain;

import com.hojo.fenix.games.domain.entity.GameEntity;

import java.util.List;

public class Games {

    private List<GameEntity> games;

    public List<GameEntity> getGames() {
        return games;
    }

    public void setGames(List<GameEntity> games) {
        this.games = games;
    }
}
