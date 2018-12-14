package com.hojo.fenix.games;

import com.hojo.fenix.games.v2.dao.repository.GameRepository;
import com.hojo.fenix.games.v2.dao.repository.PlayerRepository;
import com.hojo.fenix.games.v2.domain.entity.GameEntity;
import com.hojo.fenix.games.v2.domain.entity.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @PostConstruct
    public void initDemoData(){
        PlayerEntity p1 = new PlayerEntity();
        p1.setName("SrHojo");
        PlayerEntity p2 = new PlayerEntity();
        p2.setName("Kina");
        PlayerEntity p3 = new PlayerEntity();
        p3.setName("Patito");
        playerRepository.save(p1);
        playerRepository.save(p2);
        playerRepository.save(p3);


        GameEntity g1 = new GameEntity();
        g1.setName("Amigo invisible");
        g1.setDescription("Juega con tu familia y haceros un regalo divertido");
        gameRepository.save(g1);


        GameEntity g2 = new GameEntity();
        g2.setName("Sudoku");
        g2.setDescription("Juego de inteligencia matemática");
        gameRepository.save(g2);


        GameEntity g3 = new GameEntity();
        g3.setName("Aventureros al tren");
        g3.setDescription("Juego de mesa en el que descubriras las aventuras de viajar en tren");
        gameRepository.save(g3);


    }
}
