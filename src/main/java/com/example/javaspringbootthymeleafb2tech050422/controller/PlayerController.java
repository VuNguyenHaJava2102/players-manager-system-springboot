package com.example.javaspringbootthymeleafb2tech050422.controller;

import com.example.javaspringbootthymeleafb2tech050422.entity.Player;
import com.example.javaspringbootthymeleafb2tech050422.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping(path = "/getAllPlayers")
    public ModelAndView getAllPlayers() {
        ModelAndView modelAndView = new ModelAndView("player_list");
        modelAndView.addObject("players", this.playerRepository.findAll());

        return modelAndView;
    }

    @GetMapping(path = "/getAddPlayerForm")
    public ModelAndView getAddPlayerForm() {
        ModelAndView modelAndView = new ModelAndView("add_player_form");
        Player addNewPlayer = new Player();
        modelAndView.addObject("newPlayer",addNewPlayer);

        return modelAndView;
    }

    @PostMapping(path = "/saveNewPlayer")
    public String saveNewPlayer(@ModelAttribute Player newPlayer) {
        this.playerRepository.save(newPlayer);

        return "redirect:/getAllPlayers";
    }

    @GetMapping(path = "/getUpdatePlayerForm")
    public ModelAndView getUpdatePlayerForm(@RequestParam Long playerId) {
        ModelAndView modelAndView = new ModelAndView("update_player_form");
        Player player = this.playerRepository.findById(playerId).get();
        modelAndView.addObject("updatePlayer", player);

        return modelAndView;
    }

    @GetMapping(path = "/deletePlayer")
    public String deletePlayer(@RequestParam Long playerId) {
        this.playerRepository.deleteById(playerId);

        return "redirect:/getAllPlayers";
    }
}
