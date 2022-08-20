package com.music.service;

import com.music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> listMusic();

    void addMusic(Music music);

    Object findById(int id);

    void update( Music music);

    void delete(int id);
}
