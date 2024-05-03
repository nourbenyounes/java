package Model;


import java.util.ArrayList;
import java.util.List;

public abstract class   entreprise {
    private String nom;
    private List<Client> listeClients;
    private List<Projet> listeProjets;
    private List<Employe> listeEmployes;

    public entreprise(String nom) {
        employeBD emp = new employeBD();
        clientBD clt = new clientBD();
        this.nom = nom;
        this.listeClients = clt.getListeClientsDepuisBase();
        this.listeProjets = ProjetBD.getListeProjetsDepuisBase();
        this.listeEmployes = emp.getListeEmployesDepuisBase();
    }

    public void ajouterClient(Client client) {
        listeClients.add(client);
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    public void ajouterProjet(Projet projet) {
        listeProjets.add(projet);
    }

    public List<Projet> getListeProjets() {
        return listeProjets;
    }

    public void embaucherEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    public List<Employe> getListeEmployes() {
        return listeEmployes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void supprimerClient(int id) throws EntrepriseException {
        Client clientASupprimer = null;

        for (Client client : listeClients) {
            if (client.getId() == id) {
                clientASupprimer = client;
                break;
            }
        }

        if (clientASupprimer != null) {
            listeClients.remove(clientASupprimer);
        } else {
            throw new EntrepriseException("Client introuvable avec l'ID : " + id);
        }
    }

    public void licencierEmploye(int id) throws EntrepriseException {
        Employe employeASupprimer = null;

        for (Employe employe : listeEmployes) {
            if (employe.getId() == id) {
                employeASupprimer = employe;
                break;
            }
        }

        if (employeASupprimer != null) {
            listeEmployes.remove(employeASupprimer);
        } else {
            throw new EntrepriseException("Employé introuvable avec l'ID : " + id);
        }
    }

    public void supprimerProjet(int id) throws EntrepriseException {
        Projet projetASupprimer = null;

        for (Projet projet : listeProjets) {
            if (projet.getIdProjet() == id) {
                projetASupprimer = projet;
                break;
            }
        }

        if (projetASupprimer != null) {
            listeProjets.remove(projetASupprimer);
        } else {
            throw new EntrepriseException("Projet introuvable avec l'ID :"+id);
        }
    }
}
