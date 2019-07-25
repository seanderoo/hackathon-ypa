package com.example.demo.model;

public class Example {

    private int id;
    private String artistName;
    private String songTitel;

    public Example(int id, String artistName, String songTitel) {
        this.id = id;
        this.artistName = artistName;
        this.songTitel = songTitel;
    }

    public Example() {}

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongTitel() {
        return songTitel;
    }

    public void setSongTitel(String songTitel) {
        this.songTitel = songTitel;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", artist='" + artistName + '\'' +
                ", song=" + songTitel +
                '}';
    }
}
