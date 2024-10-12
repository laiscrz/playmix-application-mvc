package com.app.playmix.controller;

import com.app.playmix.model.Music;
import com.app.playmix.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    private final MusicService musicService;
    
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    // Retorna a lista de músicas
    @GetMapping
    public ModelAndView findAll() {
        List<Music> musics = musicService.findAllMusics();
        ModelAndView modelAndView = new ModelAndView("music/list");
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }

    // Busca uma música pelo ID
    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        Music music = musicService.findByIdMusic(id);
        ModelAndView modelAndView = new ModelAndView("music/detail");
        modelAndView.addObject("music", music);
        return modelAndView;
    }

    // Exibe o formulário para criar uma nova música
    @GetMapping("/new")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("music/form");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    // Cria uma nova música
    @PostMapping
    public String create(@ModelAttribute Music music) {
        musicService.createMusic(music);
        return "redirect:/musics"; // Redireciona para a lista de músicas
    }

    // Exibe o formulário para editar uma música existente
    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable Long id) {
        Music music = musicService.findByIdMusic(id);
        ModelAndView modelAndView = new ModelAndView("music/form");
        modelAndView.addObject("music", music);
        return modelAndView;
    }

    // Atualiza uma música existente
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Music musicDetails) {
        musicService.updateByIdMusic(id, musicDetails);
        return "redirect:/musics"; // Redireciona para a lista de músicas
    }

    // Remove uma música pelo ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        musicService.deleteByIdMusic(id);
        return "redirect:/musics"; // Redireciona para a lista de músicas
    }
}
