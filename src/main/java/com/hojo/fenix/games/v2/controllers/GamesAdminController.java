package com.hojo.fenix.games.v2.controllers;

import com.hojo.fenix.games.v2.domain.Games;
import com.hojo.fenix.games.v2.domain.Players;
import com.hojo.fenix.games.v2.domain.entity.GameEntity;
import com.hojo.fenix.games.v2.domain.entity.PlayerEntity;
import com.hojo.fenix.games.v2.service.GamesAdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/private/v1")
public class GamesAdminController {

    @Autowired
    private GamesAdminServices gamesAdminServices;

    @PostMapping("/players")
    public PlayerEntity createNewPlayer(@RequestBody @Valid PlayerEntity player) {
        return gamesAdminServices.savePlayer(player);
    }

    @PutMapping("/players/{id}")
    public PlayerEntity updatePlayer(@PathVariable("id") Integer id, @RequestBody @Valid PlayerEntity player) {
        player.setId(id);
        return gamesAdminServices.savePlayer(player);
    }

    @GetMapping("/players")
    public Players retrieveAllPlayers() {
        return gamesAdminServices.retrieveAllPlayers();
    }

    @DeleteMapping("/players/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable("id") Integer id) {
        gamesAdminServices.deletePlayer(id);
    }



    @PostMapping("/games")
    public GameEntity createNewGame(@RequestBody @Valid GameEntity game) {
        return gamesAdminServices.saveGame(game);
    }

    @PutMapping("/games/{id}")
    public GameEntity updateGame(@PathVariable("id") Integer id, @RequestBody @Valid GameEntity game) {
        game.setId(id);
        return gamesAdminServices.saveGame(game);
    }

    @GetMapping("/games")
    public Games retrieveAllGames() {
        return gamesAdminServices.retrieveAllGames();
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") Integer id) {
        gamesAdminServices.deleteGame(id);
    }


}
