package com.music.service.impl;

import com.music.model.Music;
import com.music.repository.IMusicRepository;
import com.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> listMusic(String name) {
        return musicRepository.listMusic(name);
    }

    @Value("${file-upload}")
    private String fileUpload;

    @Override
    public void addMusic(Music music) {
        MultipartFile multipartFile = music.getSongFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(music.getSongFilePath().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        music.setLink(fileName);
        musicRepository.addMusic(music);
    }

    @Override
    public Object findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        MultipartFile multipartFile = music.getSongFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(music.getSongFilePath().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        music.setLink(fileName);
        musicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }
}
