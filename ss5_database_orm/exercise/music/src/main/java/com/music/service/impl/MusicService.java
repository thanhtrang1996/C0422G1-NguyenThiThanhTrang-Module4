package com.music.service.impl;

import com.music.model.Music;
import com.music.repository.IMusicRepository;
import com.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> listMusic(String name) {
        return musicRepository.listMusic(name);
    }

    @Override
    public void addMusic(Music music) {
        musicRepository.addMusic(music);
    }

    @Override
    public Object findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }
}
