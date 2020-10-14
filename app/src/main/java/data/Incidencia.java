package data;

import java.io.Serializable;

public class Incidencia implements Serializable {
    public String nom;
    public String prioritat;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrioritat() {
        return prioritat;
    }

    public void setPrioritat(String prioritat) {
        this.prioritat = prioritat;
    }
}
