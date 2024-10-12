package com.app.playmix.controller;

import com.app.playmix.model.Music;
import com.app.playmix.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
        ModelAndView modelAndView = new ModelAndView("music/list");
        modelAndView.addObject("musics", musicService.findAllMusics());
        return modelAndView;
    }

    // Busca uma música pelo ID
    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        Music music = musicService.findByIdMusic(id);
        ModelAndView modelAndView = new ModelAndView("music/details");
        modelAndView.addObject("music", music);
        return modelAndView;
    }

    // Exibe o formulário para criar uma nova música
    @GetMapping("/new")
    public ModelAndView musicForm() {
        ModelAndView modelAndView = new ModelAndView("music/form");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    // Cria uma nova música
    @PostMapping
    public ModelAndView musicSubmit(@Valid @ModelAttribute Music music, BindingResult result) {
       if (result.hasErrors()){
           return new ModelAndView("music/form");
       }

       musicService.createMusic(music);
       return new ModelAndView("redirect:/musics");
    }

    // Exibe o formulário para editar uma música existente
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("music/form");
        modelAndView.addObject("music", musicService.findByIdMusic(id));
        return modelAndView;
    }

    // Remove uma música pelo ID
    @GetMapping("/delete/{id}")
    public ModelAndView deleteMusic(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("music/list");
        try {
            musicService.deleteByIdMusic(id);
            modelAndView.setViewName("redirect:/music");
            modelAndView.addObject("message", "Música excluída com sucesso.");
        } catch (RuntimeException e) {
            modelAndView.addObject("error", e.getMessage());
        }
        modelAndView.addObject("musics", musicService.findAllMusics());
        return modelAndView;
    }


}
