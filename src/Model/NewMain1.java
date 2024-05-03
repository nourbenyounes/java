/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;



//import java.util.List;

//public class NewMain1 {

   // public static void main(String[] args) {
/*
                // Création d'une instance de clientBD
        clientBD clientBDInstance = new clientBD();

        // Ajout d'un nouveau client
        Client nouveauClient = new Client(0, "Nouveau", "Client", "nouveau.client@example.com", 0, "");
        clientBDInstance.ajouterClientEnBase(nouveauClient);


        // Affichage de la liste des clients
        List<Client> listeClients = clientBDInstance.getListeClientsDepuisBase();
        System.out.println("Liste des clients :");
        for (Client client : listeClients) {
            System.out.println(client);

        }

        // Mise à jour du premier client (assurez-vous d'avoir au moins un client dans la base avant d'exécuter)
        if (!listeClients.isEmpty()) {
            Client premierClient = listeClients.get(0);
            premierClient = new Client(premierClient.getId(), "NomModifie", "PrenomModifie", "MailModifie", 1, "CommentaireModifie");
            clientBDInstance.mettreAJourClientEnBase(premierClient);
        }

        // Affichage de la liste mise à jour
        listeClients = clientBDInstance.getListeClientsDepuisBase();
        System.out.println("Liste des clients mise à jour :");
        for (Client client : listeClients) {
            System.out.println(client);
        }

        // Récupération d'un client par son ID
        if (!listeClients.isEmpty()) {
            int clientId = listeClients.get(0).getId();
            Client clientParId = clientBDInstance.getClientParIdDepuisBase(clientId);
            System.out.println("Client par ID : " + clientParId);
        }

        // Suppression du premier client (assurez-vous d'avoir au moins un client dans la base avant d'exécuter)
        if (!listeClients.isEmpty()) {
            int clientId = listeClients.get(0).getId();
            clientBDInstance.supprimerClientEnBase(clientId);
            System.out.println("Client supprimé.");
        }*/
        // Création d'une instance de employeBD
       /* employeBD employeBDInstance = new employeBD();

        // Ajout d'un nouvel employé
        Tache tacheEmploye = new Tache(1, 1, "2023-01-01", "2023-03-03", "description", "Non");
        Employe nouvelEmploye = new Employe(0, "Nouveau", "Employe", "nouveau.employe@example.com", "Ingénieur", tacheEmploye, 1);
        employeBDInstance.ajouterEmployeEnBase(nouvelEmploye);

        // Affichage de la liste des employés
        List<Employe> listeEmployes = employeBDInstance.getListeEmployesDepuisBase();
        System.out.println("Liste des employés :");
        for (Employe employe : listeEmployes) {
            System.out.println(employe);
        }*/
        
/*
        // Mise à jour du premier employé (assurez-vous d'avoir au moins un employé dans la base avant d'exécuter)
        if (!listeEmployes.isEmpty()) {
            premierEmploye = new Employe(premierEmploye.getId(), "NomModifie", "PrenomModifie", "MailModifie", "GradeModifie", tacheEmploye, 2);
            employeBDInstance.mettreAJourEmployeEnBase(premierEmploye);
        }

        // Affichage de la liste mise à jour
        listeEmployes = employeBDInstance.getListeEmployesDepuisBase();
        System.out.println("Liste des employés mise à jour :");
        for (Employe employe : listeEmployes) {
            System.out.println(employe);
        }

        // Récupération d'un employé par son ID
        if (!listeEmployes.isEmpty()) {
            int employeId = listeEmployes.get(0).getId();
            Employe employeParId = employeBDInstance.getEmployeParIdDepuisBase(employeId);
            System.out.println("Employé par ID : " + employeParId);
        }

        // Suppression du premier employé (assurez-vous d'avoir au moins un employé dans la base avant d'exécuter)
        if (!listeEmployes.isEmpty()) {
            int employeId = listeEmployes.get(0).getId();
            employeBDInstance.supprimerEmployeEnBase(employeId);
            System.out.println("Employé supprimé.");
        }*/
// Création d'une instance de TacheBD
      /*  TacheBD tacheBDInstance = new TacheBD();

        // Ajout d'une nouvelle tâche
        Tache nouvelleTache = new Tache(0, 1, "2023-01-01", "2023-02-01", "Description de la tâche", "En cours");
        tacheBDInstance.ajouterTacheEnBase(nouvelleTache);

        // Affichage de la liste des tâches
        List<Tache> listeTaches = tacheBDInstance.getListeTachesDepuisBase();
        System.out.println("Liste des tâches :");
        for (Tache tache : listeTaches) {
            System.out.println(tache);
        }

        // Mise à jour de la première tâche (assurez-vous d'avoir au moins une tâche dans la base avant d'exécuter)
        if (!listeTaches.isEmpty()) {
            Tache premiereTache = listeTaches.get(0);
            premiereTache = new Tache(premiereTache.getIdTache(), 2, "2023-02-01", "2023-03-01", "Nouvelle description", "Terminée");
            tacheBDInstance.mettreAJourTacheEnBase(premiereTache);
        }

        // Affichage de la liste mise à jour
        listeTaches = tacheBDInstance.getListeTachesDepuisBase();
        System.out.println("Liste des tâches mise à jour :");
        for (Tache tache : listeTaches) {
            System.out.println(tache);
        }

        // Récupération d'une tâche par son ID
        if (!listeTaches.isEmpty()) {
            int tacheId = listeTaches.get(0).getIdTache();
            Tache tacheParId = tacheBDInstance.getTacheParIdDepuisBase(tacheId);
            System.out.println("Tâche par ID : " + tacheParId);
        }

        // Suppression de la première tâche (assurez-vous d'avoir au moins une tâche dans la base avant d'exécuter)
        if (!listeTaches.isEmpty()) {
            int tacheId = listeTaches.get(0).getIdTache();
            tacheBDInstance.supprimerTacheEnBase(tacheId);
            System.out.println("Tâche supprimée.");
        }
    }
}*/

