package com.music.repository;

import com.music.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> listMusic(String name);

    void addMusic(Music music);

    Object findById(int id);

    void update(Music music);

    void delete(int id);
}
