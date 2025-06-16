package notif;

public class Admin {
    private String nom;
    private String password;
    private String email;
    public Admin(String nom, String password) {
        this.nom = "admin";
        this.password = "12345678";
        this.email = "knanete@gmail.com";
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
