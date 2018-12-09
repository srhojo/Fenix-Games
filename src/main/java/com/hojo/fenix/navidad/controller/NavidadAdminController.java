package com.hojo.fenix.navidad.controller;

import com.hojo.fenix.navidad.NavidadService;
import com.hojo.fenix.navidad.entity.PlayerEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/private")
public class NavidadAdminController {

    private final NavidadService navidadService;

    public NavidadAdminController(NavidadService navidadService) {
        this.navidadService = navidadService;
    }

    @GetMapping("/panel")
    public String adminInit(Model model) {
        basiWebModel(model);
        return "private/admin";
    }


    //@PostMapping("/private/addPlayer")
    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public String adminAddPlayer(@ModelAttribute("player") PlayerEntity player, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            navidadService.guardar(player);
            basiWebModel(model);
            return "private/admin";
        } else {
            //Hacer algo con los errores
            return "redirect:/private/admin";
        }
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.DELETE)
    public String removePlayer(@PathVariable("id") Long id,Model model){
        navidadService.borrarJugador(id);
        basiWebModel(model);
        return "private/admin";
    }
    @RequestMapping(value = "/players/reset", method = RequestMethod.POST)
    public String resetPlay(Model model){
        navidadService.resetearJuego();
        basiWebModel(model);
        return "private/admin";
    }


    private void basiWebModel(Model model) {
        model.addAttribute("players", navidadService.recuperarJugadores());
        model.addAttribute("newPlayer", new PlayerEntity());
    }


}
