package com.hojo.fenix.games.entity;

import java.io.Serializable;
import java.util.List;

public class Players implements Serializable {


    List<PlayerEntity> players;

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }
}
