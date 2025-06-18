package model;

public class User {
	private String nom, email;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public User(String nom, String email) {
		this.nom= nom;
		this.email=email;
	}
	
	public String getNom() {
		return nom;
	}	
	public String getEmail() {
		return email;
	}
	public void setNom (String nom) {
		this.nom=nom;
	}
	public void setEmail (String email) {
		this.email=email;
	}

}
