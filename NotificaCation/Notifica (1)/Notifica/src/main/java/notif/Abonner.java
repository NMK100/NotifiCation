package notif;

import java.util.ArrayList;
import java.util.List;

public class Abonner {
    private String email;
    private boolean actif;
    private List<String> categories;

    public Abonner(String email) {
        this.email = email;
        this.actif = true;
        this.categories = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public boolean estActif() {
        return actif;
    }

    public void desactiver() {
        this.actif = false;
    }

    public void activer() {
        this.actif = true;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void ajouterCategorie(String categorie) {
        if (!categories.contains(categorie)) {
            categories.add(categorie);
        }
    }

    public void retirerCategorie(String categorie) {
        categories.remove(categorie);
    }
}
