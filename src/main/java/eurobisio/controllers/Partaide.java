package eurobisio.controllers;

import javafx.scene.image.Image;

import java.io.File;

public class Partaide {
    private String herrialdea;
    private String artista;
    private String abestia;
    private Integer puntuak;
    private Image argazkia;

    public Image getArgazkia() {
        return argazkia;
    }

    public void setArgazkia(Image argazkia) {
        this.argazkia = argazkia;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }
}
