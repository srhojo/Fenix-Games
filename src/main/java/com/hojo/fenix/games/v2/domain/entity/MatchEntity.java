package com.hojo.fenix.games.v2.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "FG_MATCH")
public class MatchEntity {

    @Id
    private Integer id;

    private Integer gameId; //TODO: FK key

    //private List<Pla>

}
