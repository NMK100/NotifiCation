package notif;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEmploye {
    public static List<Employe> employees = new ArrayList<>();
    static List<Message> messages = new ArrayList<>();
    private static List<Abonner> abonnes = new ArrayList<>();

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        int choix;
        // C'est le view de mon app

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Lister les employés");
            System.out.println("3. Envoyer un message à un employé");
            System.out.println("4. Voir les messages reçus");
            System.out.println("5. Gérer les abonnements");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consomme le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Numéro : ");
                    String numero = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();

                    Employe employe = new Employe(nom, prenom, numero, email);
                    employees.add(employe);
                    System.out.println("✅ Employé ajouté !");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("⚠️ Aucun employé enregistré.");
                    } else {
                        System.out.println("\n📋 Liste des employés :");
                        for (Employe emp : employees) {
                            System.out.println(emp.getPrenom() + " " + emp.getNom()
                                    + " | " + emp.getNumero() + " | " + emp.getEmail());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Email du destinataire : ");
                    String dest = scanner.nextLine();
                    System.out.print("Message : ");
                    String contenu = scanner.nextLine();
                    for (Employe e : employees) {
                        System.out.println("Message Envoyé a :"+e.getNom()+" "+e.getPrenom());
                        messages.add(new Message(contenu, e.getEmail(), "Admin"));
                    }
                    System.out.println("✅ Message envoyé !");
                    break;
                case 4:
                    for (Message m : messages) {
                        if (m.getDestinataire().equals("Admin")) {
                            System.out.println("De : " + m.getExpediteur());
                            System.out.println("Message : " + m.getContenu());
                            m.marquerCommeLu();
                        }
                    }
                    break;
                case 5:
                    gererAbonnements(scanner);
                    break;
                case 0:
                    System.out.println("👋 Au revoir !");
                    break;

                default:
                    System.out.println("❌ Choix invalide. Réessayez.");
            }

        } while (choix != 0);

        scanner.close();
    }

    private static void gererAbonnements(Scanner scanner) {
        System.out.println("\n===== GESTION DES ABONNEMENTS =====");
        System.out.println("1. Ajouter un abonné");
        System.out.println("2. Désactiver un abonné");
        System.out.println("3. Activer un abonné");
        System.out.println(". Lister tous les abonnés");
        System.out.println("0. Retour au menu principal");
        System.out.print("Votre choix : ");

        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme le retour à la ligne

        switch (choix) {
            case 1:
                System.out.print("Email de l'abonné à ajouter : ");
                String email = scanner.nextLine();
                abonnes.add(new Abonner(email));
                System.out.println("✅ Abonné ajouté avec succès !");
                break;

            case 2:
                System.out.print("Email de l'abonné à désactiver : ");
                String emailDesactiver = scanner.nextLine();
                for (Abonner abonne : abonnes) {
                    if (abonne.getEmail().equals(emailDesactiver)) {
                        abonne.desactiver();
                        System.out.println("✅ Abonné désactivé avec succès !");
                        break;
                    }
                }
                break;

            case 3:
                System.out.print("Email de l'abonné à activer : ");
                String emailActiver = scanner.nextLine();
                for (Abonner abonne : abonnes) {
                    if (abonne.getEmail().equals(emailActiver)) {
                        abonne.activer();
                        System.out.println("✅ Abonné activé avec succès !");
                        break;
                    }
                }
                break;

            case 4:
                if (abonnes.isEmpty()) {
                    System.out.println("⚠️ Aucun abonné enregistré.");
                } else {
                    System.out.println("\n📋 Liste des abonnés :");
                    for (Abonner abonne : abonnes) {
                        System.out.println("Email: " + abonne.getEmail() + 
                                         " | Statut: " + (abonne.estActif() ? "Actif" : "Inactif") +
                                         " | Catégories: " + abonne.getCategories());
                    }
                }
                break;

            case 0:
                return;

            default:
                System.out.println("❌ Choix invalide. Réessayez.");
        }
    }
}
