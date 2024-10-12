package com.app.playmix.service;

import com.app.playmix.model.Playlist;
import com.app.playmix.repository.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private final IPlaylistRepository playlistRepository;

    public PlaylistService(IPlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    // Retorna todas as playlists
    public List<Playlist> findAllPlaylists() {
        return playlistRepository.findAll();
    }

    // Busca uma playlist pelo ID
    public Playlist findByIdPlaylist(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    // Cria uma nova playlist
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Atualiza uma playlist existente
    public Playlist updateByIdPlaylist(Long id, Playlist playlistDetails) {
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if (playlist != null) {
            playlist.setNome(playlistDetails.getNome());
            playlist.setMusicas(playlistDetails.getMusicas());

            return playlistRepository.save(playlist);
        }
        return null;
    }

    // Remove uma playlist pelo ID
    public void deleteByIdPlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
