package notif;
    public class Message {
        private String contenu;
        private String expediteur;  // "admin" ou email de l'employé
        private String destinataire;
        private boolean lu; // false = non lu, true = déjà lu

        public Message(String contenu, String expediteur, String destinataire) {
            this.contenu = contenu;
            this.expediteur = "knanete@gmail.com";
            this.destinataire = destinataire;
            this.lu = false;
        }

        public String getContenu() {

            return contenu;
        }

        public String getExpediteur() {

            return expediteur;
        }

        public String getDestinataire() {

            return destinataire;
        }

        public void marquerCommeLu() {
            this.lu = true;
        }

        public boolean estLu() {
            return lu;
        }
    }
