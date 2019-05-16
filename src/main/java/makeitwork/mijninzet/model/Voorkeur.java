package makeitwork.mijninzet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voorkeur {

    private String naamVak;

    private int voorkeurVak;

    private List<VoorkeurSchaal> voorkeurSchaal;

    public Voorkeur() {
    }

    public Voorkeur(String naamVak, int voorkeurVak, List<VoorkeurSchaal> voorkeurSchaal) {
        this.naamVak = naamVak;
        this.voorkeurVak = voorkeurVak;
        this.voorkeurSchaal = voorkeurSchaal;
    }

    public Voorkeur(String naamVak, int voorkeurVak) {
        this.naamVak = naamVak;
        this.voorkeurVak = voorkeurVak;
    }

    public String getNaamVak() {
        return naamVak;
    }

    public void setNaamVak(String naamVak) {
        this.naamVak = naamVak;
    }

    public int getVoorkeurVak() {
        return voorkeurVak;
    }

    public void setVoorkeurVak(int voorkeurVak) {
        this.voorkeurVak = voorkeurVak;
    }

    public List<VoorkeurSchaal> getVoorkeurSchaal() {
        return voorkeurSchaal;
    }

    public void setVoorkeurSchaal(List<VoorkeurSchaal> voorkeurSchaal) {
        this.voorkeurSchaal = voorkeurSchaal;
    }

    @Override
    public String toString() {
        return "Voorkeur{" +
                "naamVak='" + naamVak + '\'' +
                ", voorkeurVak=" + voorkeurVak +
                ", voorkeurSchaal=" + voorkeurSchaal +
                '}';
    }
}
