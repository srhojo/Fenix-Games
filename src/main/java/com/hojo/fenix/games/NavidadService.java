package com.hojo.fenix.games;

import com.hojo.fenix.games.entity.PlayerEntity;
import com.hojo.fenix.games.entity.Players;
import com.hojo.fenix.games.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class NavidadService {

    private final PlayerRepository playerRepository;

    @Autowired
    public NavidadService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerEntity> recuperarJugadoresLibres() {
        return playerRepository.findAllByJuegadoFalse();
    }

    public PlayerEntity guardar(PlayerEntity newPLayer) {
        playerRepository.findByNombre(newPLayer.getNombre()).map(player -> {
            throw new RuntimeException(String.format("EL jugador ya existe en la BBDD", player.getNombre()));
        }).orElse(playerRepository.save(newPLayer));

        return newPLayer;
    }

    public PlayerEntity jugar(String nombre) {
        Optional<PlayerEntity> playerOp = playerRepository.findByNombreAndJuegadoFalse(nombre);

        return playerOp.map(playerEntity -> {
            List<PlayerEntity> players = playerRepository.findFreePlayers(playerEntity.getNombre());
            Integer randomNumber = new Random().nextInt(players.size());
            PlayerEntity jugardorAsignado = players.get(randomNumber);
            playerEntity.setAsigandoA(jugardorAsignado.getNombre());
            playerEntity.setFechaJugado(LocalDateTime.now());
            playerEntity.setJuegado(Boolean.TRUE);
            return playerRepository.save(playerEntity);
        }).orElseThrow(() -> new RuntimeException("El jugador seleccionado no está disponible"));

    }

    public Players recuperarJugadores() {
        Players players = new Players();
        players.setPlayers(playerRepository.findAll());
        return players;
    }

    public void borrarJugador(Long id) {
        playerRepository.deleteById(id);
    }

    public void resetearJuego(){
        List<PlayerEntity> jugadores = playerRepository.findAll();
        jugadores.forEach(p ->{
            p.setAsigandoA(null);
            p.setJuegado(Boolean.FALSE);
            p.setFechaJugado(null);
            playerRepository.save(p);
        });
    }

}
