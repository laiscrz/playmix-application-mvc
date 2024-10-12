package com.app.playmix.controller;

import com.app.playmix.model.Playlist;
import com.app.playmix.service.MusicService;
import com.app.playmix.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;

    @Autowired
    private final MusicService musicService;

    public PlaylistController(PlaylistService playlistService, MusicService musicService) {
        this.playlistService = playlistService;
        this.musicService = musicService;
    }

    // Exibe a lista de playlists
    @GetMapping
    public ModelAndView listPlaylists() {
        List<Playlist> playlists = playlistService.findAllPlaylists();
        ModelAndView modelAndView = new ModelAndView("playlist/list");
        modelAndView.addObject("playlists", playlists);
        return modelAndView;
    }

    // Exibe o formulário para adicionar uma nova playlist
    @GetMapping("/new")
    public ModelAndView showCreatePlaylistForm() {
        ModelAndView modelAndView = new ModelAndView("playlist/form");
        modelAndView.addObject("playlist", new Playlist());
        modelAndView.addObject("music", musicService.findAllMusics());
        return modelAndView;
    }

    // Processa a criação de uma nova playlist
    @PostMapping
    public String savePlaylist(@ModelAttribute Playlist playlist) {
        playlistService.savePlaylist(playlist);
        return "redirect:/playlists";
    }

    // Exibe o formulário para editar uma playlist existente
    @GetMapping("/edit/{id}")
    public ModelAndView showEditPlaylistForm(@PathVariable Long id) {
        Playlist playlist = playlistService.findByIdPlaylist(id);
        ModelAndView modelAndView = new ModelAndView("playlist/form");
        modelAndView.addObject("playlist", playlist);
        return modelAndView;
    }

    // Processa a atualização de uma playlist existente
    @PostMapping("/{id}")
    public String updatePlaylist(@PathVariable Long id, @ModelAttribute Playlist playlist) {
        playlist.setId(id);
        playlistService.savePlaylist(playlist);
        return "redirect:/playlists";
    }

    // Remove uma playlist pelo ID
    @PostMapping("/delete/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        playlistService.deleteByIdPlaylist(id);
        return "redirect:/playlists";
    }
}
