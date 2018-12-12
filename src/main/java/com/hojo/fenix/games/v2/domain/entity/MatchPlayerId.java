package com.hojo.fenix.games.v2.domain.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class MatchPlayerId implements Serializable {

    @Id
    private Integer matchId;

    @Id
    private Integer PlayerId;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(Integer playerId) {
        PlayerId = playerId;
    }
}
