package com.music.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "song_name")
    private String nameOfSong;
    @Column(name = "performing_artist")
    private String performingArtist;
    @Column(name = "kind_music")
    private String kindOfMusic;
    @Column(name = "song_file_path")
    private String songFilePath;

    public Music() {
    }

    public Music(int id, String nameOfSong, String performingArtist, String kindOfMusic, String songFilePath) {
        this.id = id;
        this.nameOfSong = nameOfSong;
        this.performingArtist = performingArtist;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
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

    public String getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(String songFilePath) {
        this.songFilePath = songFilePath;
    }
}
