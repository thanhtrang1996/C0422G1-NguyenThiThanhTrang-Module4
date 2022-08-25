package com.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z])*", message = "Please enter name")
    @Size(min = 1, max = 800)
    @Column(name = "name")
    private String nameOfSong;
    @Pattern(regexp = "(([A-Za-z])+(\\s[A-Za-z])*)", message = "Please enter artist")
    @Size(min = 1, max = 300)
    @Column(name = "artist")
    private String performingArtist;
    @Size(min =1,max = 1000)
    @Pattern(regexp = "^[\\w ,]+$",message = "Please enter kind of music")
    @Column(name = "kind")
    private String kindOfMusic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public String getPerformingArtist() {
        return performingArtist;
    }

    public void setPerformingArtist(String performingArtist) {
        this.performingArtist = performingArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
