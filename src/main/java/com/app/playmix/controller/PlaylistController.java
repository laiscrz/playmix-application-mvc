package com.app.playmix.controller;

import com.app.playmix.model.Playlist;
import com.app.playmix.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    // Retorna a lista de playlists
    @GetMapping
    public ModelAndView findAll(Model model) {
        List<Playlist> playlists = playlistService.findAllPlaylists();
        model.addAttribute("playlists", playlists);
        return new ModelAndView("playlist/list");
    }

    // Busca uma playlist pelo ID
    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        Playlist playlist = playlistService.findByIdPlaylist(id);
        ModelAndView modelAndView = new ModelAndView("playlist/details");
        modelAndView.addObject("playlist", playlist);
        return modelAndView;
    }

    // Exibe o formulário para criar uma nova playlist
    @GetMapping("/form")
    public String showCreateForm(Model model) {
        model.addAttribute("playlist", new Playlist());
        return "playlist/form"; // Nome da sua view para o formulário
    }

    // Exibe o formulário para editar uma playlist existente
    @GetMapping("/form/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Playlist playlist = playlistService.findByIdPlaylist(id);
        model.addAttribute("playlist", playlist);
        return "playlist/form"; // Nome da sua view para o formulário
    }

    // Cria uma nova playlist
    @PostMapping
    public String create(@ModelAttribute Playlist playlist) {
        playlistService.createPlaylist(playlist);
        return "redirect:/playlists";
    }

    // Atualiza uma playlist existente
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Playlist playlistDetails) {
        playlistService.updateByIdPlaylist(id, playlistDetails);
        return "redirect:/playlists";
    }

    // Remove uma playlist pelo ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        playlistService.deleteByIdPlaylist(id);
        return "redirect:/playlists";
    }
}
