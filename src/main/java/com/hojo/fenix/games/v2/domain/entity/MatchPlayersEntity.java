package com.hojo.fenix.games.v2.domain.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "FG_MATCH_PLAYERS")
public class MatchPlayersEntity {

    @EmbeddedId
    private MatchPlayerId matchId;

    public MatchPlayerId getMatchId() {
        return matchId;
    }

    public void setMatchId(MatchPlayerId matchId) {
        this.matchId = matchId;
    }
}
