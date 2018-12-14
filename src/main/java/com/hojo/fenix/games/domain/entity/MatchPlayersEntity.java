package com.hojo.fenix.games.domain.entity;

import javax.persistence.EmbeddedId;

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
