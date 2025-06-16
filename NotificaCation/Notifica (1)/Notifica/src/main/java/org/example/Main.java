package org.example;

import java.util.Scanner;

import notif.Admin;
import notif.Employe;
import notif.GestionEmploye;
import notif.Message;
import java.util.ArrayList;
import java.util.List;

//import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

public class Main {

    public static void main(String[] args) {
        List<Message> messages = new ArrayList<>();
        Scanner nmk = new Scanner(System.in);
        List<Employe> employeList = GestionEmploye.employees;
        System.out.println("\n=======Hello and welcome!=======");
        
        int choix;
        do {
            System.out.println("\n1. Se connecter (Admin)");
            System.out.println("2. Se connecter (Employe)");
            System.out.println("3. Quitter");
            System.out.print("Veuillez saisir le choix: ");
            choix = nmk.nextInt();
            nmk.nextLine(); // Consomme le retour à la ligne

            switch (choix) {
                case 1: // Connexion Admin
                    System.out.print("Veuillez saisir votre nom d'admin: ");
                    String adminNom = nmk.nextLine();
                    System.out.print("Veuillez saisir le mot de passe: ");
                    String adminPassword = nmk.nextLine();

                    Admin admin = new Admin(adminNom, adminPassword);
                    if (adminNom.equals(admin.getNom()) && adminPassword.equals(admin.getPassword())) {
                        System.out.println("Connexion réussie avec succès et Bienvenue !");
                        GestionEmploye.menu();
                    } else {
                        System.out.println("Identifiants incorrects. Veuillez réessayer.");
                    }
                    break;

                case 2: // Connexion Employé
                    System.out.print("Veuillez saisir votre nom : ");
                    String nomEmploye = nmk.nextLine();
                    System.out.print("Veuillez saisir le mot de passe : ");
                    String passwordEmploye = nmk.nextLine();
                    System.out.print("Veuillez saisir votre email : ");
                    String email = nmk.nextLine();

                    System.out.println("\n1. Voir mes messages");
                    System.out.println("2. Envoyer un message à l'admin");
                    System.out.print("Votre choix : ");
                    int employeChoix = nmk.nextInt();
                    nmk.nextLine(); // Consomme le retour à la ligne

                    switch (employeChoix) {
                        case 1:
                            boolean messageTrouve = false;
                            for (Message m : messages) {
                                if (m.getDestinataire().equals(email)) {
                                    System.out.println("\nDe : " + m.getExpediteur());
                                    System.out.println("Message : " + m.getContenu());
                                    m.marquerCommeLu();
                                    messageTrouve = true;
                                }
                            }
                            if (!messageTrouve) {
                                System.out.println("Pas de message pour le moment.");
                            }
                            break;

                        case 2:
                            System.out.print("Message : ");
                            String contenu = nmk.nextLine();
                            messages.add(new Message(contenu, email, "knanete@gmail.com"));
                            System.out.println("✅ Message envoyé !");
                            break;

                        default:
                            System.out.println("Choix invalide.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
            while (choix != 3) ;

            nmk.close();
        }
    }
}