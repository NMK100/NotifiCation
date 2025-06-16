package notif;

import java.util.ArrayList;
import java.util.List;

public class Employe {
    private String nom;
    private String prenom;
    private String numero;
    private String email;

    public Employe(String nom, String prenom, String numero, String email) {
        List<Employe> employes = new ArrayList<>();
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    //public void setEmail(String email) {
        //this.email = email;
    //}

}
