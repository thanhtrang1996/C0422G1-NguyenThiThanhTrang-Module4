package com.music.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String nameOfSong;

    @Column(name = "artist")
    private String performingArtist;

    @Column(name = "kind")
    private String kindOfMusic;

    @Column(name = "path")
    private String link;

    private transient MultipartFile songFilePath;

    public Music() {
    }

    public Music(int id, String nameOfSong, String performingArtist, String kindOfMusic, String link) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.performingArtist = performingArtist;
        this.kindOfMusic = kindOfMusic;
        this.link = link;
    }


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

    public MultipartFile getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(MultipartFile songFilePath) {
        this.songFilePath = songFilePath;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
