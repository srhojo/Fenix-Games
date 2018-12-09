package com.hojo.fenix.navidad.controller;

import com.hojo.fenix.navidad.NavidadService;
import com.hojo.fenix.navidad.entity.JugarRequest;
import com.hojo.fenix.navidad.entity.PlayerEntity;
import com.hojo.fenix.navidad.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller()
public class NavidadController {

    private final PlayerRepository playerRepository;

    private final NavidadService navidadService;

    @Autowired
    public NavidadController(PlayerRepository playerRepository, NavidadService navidadService) {
        this.playerRepository = playerRepository;
        this.navidadService = navidadService;
    }

    /* Métodos públicos*/
    @GetMapping("/navidad")
    public String initPoint(Model model) {
        model.addAttribute("players", navidadService.recuperarJugadoresLibres());

        return "navidad";
    }

    @PostMapping("/navidad/jugar/{nombre}")
    @ResponseBody
    public JugarRequest jugar(@Valid @PathVariable("nombre") String nombre) {

        JugarRequest request = new JugarRequest();
        request.setNombre(nombre);

        //PlayerEntity jugador = navidadService.jugar(request.getNombre());
        //request.setAsignado(jugador.getAsigandoA());
        request.setAsignado("Marta");
        return request;
    }



    /*Métodos del API*/

    @PostMapping("/players")
    PlayerEntity addParticipante(@RequestBody @Valid PlayerEntity p) {
        return playerRepository.save(p);
    }

    @GetMapping("/players")
    List<PlayerEntity> findAll() {
        return playerRepository.findAll();
    }

    @DeleteMapping("/players/{id}")
    void deleteParticipante(@PathVariable("id") long id) {
        playerRepository.deleteById(id);
    }
}
