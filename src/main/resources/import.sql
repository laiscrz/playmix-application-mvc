INSERT INTO music (ano_lancamento, album, artista, genero, titulo, album_art_url) VALUES (1996, 'All Eyez on Me', '2Pac', 'Hip-Hop', 'California Love', 'https://abrir.link/ZjOqm');
INSERT INTO music (ano_lancamento, album, artista, genero, titulo, album_art_url) VALUES (2020, 'Future Nostalgia', 'Dua Lipa', 'Pop', 'Dont Start Now', 'https://abrir.link/fltfI');
INSERT INTO music (ano_lancamento, album, artista, genero, titulo, album_art_url) VALUES (2019, 'Lover', 'Taylor Swift', 'Pop', 'You Need to Calm Down', 'https://abrir.link/MVajI');
INSERT INTO music (ano_lancamento, album, artista, genero, titulo, album_art_url) VALUES (2018, 'Scorpion', 'Drake', 'Hip-Hop', 'In My Feelings', 'https://abrir.link/cxgTc');
INSERT INTO music (ano_lancamento, album, artista, genero, titulo, album_art_url) VALUES (2022, 'Planet Her', 'Doja Cat', 'R&B', 'Kiss Me More', 'https://abrir.link/xRmKc');


INSERT INTO playlist (data_criacao, nome) VALUES (CURRENT_DATE, 'Minhas Favoritas');
INSERT INTO playlist (data_criacao, nome) VALUES (CURRENT_DATE, 'Para Relaxar');
INSERT INTO playlist (data_criacao, nome) VALUES (CURRENT_DATE, 'Workout Playlist');
INSERT INTO playlist (data_criacao, nome) VALUES (CURRENT_DATE, 'Top Hits 2023');

INSERT INTO playlist_music (music_id, playlist_id) VALUES (1, 1);  -- Love Story na playlist "Minhas Favoritas"
INSERT INTO playlist_music (music_id, playlist_id) VALUES (2, 1);  -- Don't Start Now na playlist "Minhas Favoritas"
INSERT INTO playlist_music (music_id, playlist_id) VALUES (3, 2);  -- You Need to Calm Down na playlist "Para Relaxar"
INSERT INTO playlist_music (music_id, playlist_id) VALUES (4, 3);  -- In My Feelings na playlist "Workout Playlist"
INSERT INTO playlist_music (music_id, playlist_id) VALUES (5, 4);  -- Kiss Me More na playlist "Top Hits 2023"
INSERT INTO playlist_music (music_id, playlist_id) VALUES (1, 4);  -- Love Story na playlist "Top Hits 2023"
INSERT INTO playlist_music (music_id, playlist_id) VALUES (2, 3);  -- Don't Start Now na playlist "Workout Playlist"

