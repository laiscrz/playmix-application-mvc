package com.app.playmix.service;

import com.app.playmix.model.Music;
import com.app.playmix.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private final IMusicRepository musicRepository;

    public MusicService(IMusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    // Retorna todas as músicas
    public List<Music> findAllMusics() {
        return musicRepository.findAll();
    }

    // Busca uma música pelo ID
    public Music findByIdMusic(Long id) {
        return musicRepository.findById(id).orElse(null);
    }

    // Cria uma nova música
    public Music createMusic(Music music) {
        return musicRepository.save(music);
    }

    // Atualiza uma música existente
    public Music updateByIdMusic(Long id, Music musicDetails) {
        Music music = musicRepository.findById(id).orElse(null);
        if (music != null) {
            music.setTitulo(musicDetails.getTitulo());
            music.setArtista(musicDetails.getArtista());
            music.setAnoLancamento(musicDetails.getAnoLancamento());
            music.setAlbum(musicDetails.getAlbum());
            music.setGenero(musicDetails.getGenero());
            music.setAlbumArtUrl(musicDetails.getAlbumArtUrl());
            return musicRepository.save(music);
        }
        return null;
    }

    // Remove uma música pelo ID
    public void deleteByIdMusic(Long id) {
        Music music = findByIdMusic(id);
        if (music != null && (music.getPlaylists() != null && !music.getPlaylists().isEmpty())) {
            throw new RuntimeException("A música está vinculada a uma playlist. Remova-a da playlist primero antes de excluir.");
        }
        musicRepository.deleteById(id);
    }

}
