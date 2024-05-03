package Model;

public class Projet {
    private int id_proj;  
    private String nom;  
    private String datedeb;  
    private String datefin;  
    private double montant;  
    private int id_client;  
    private int id_chef;  

    public Projet(int id_proj, String nom, String datedeb, String datefin, double montant, int id_client, int id_chef) {
        this.id_proj = id_proj;
        this.nom = nom;
        this.datedeb = datedeb;
        this.datefin = datefin;
        this.montant = montant;
        this.id_client = id_client;
        this.id_chef = id_chef;
    }

    public int getIdProjet() {
        return id_proj;
    }

    public void setIdProjet(int id_proj) {
        this.id_proj = id_proj;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDebut() {
        return datedeb;
    }

    public void setDateDebut(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDateFin() {
        return datefin;
    }

    public void setDateFin(String datefin) {
        this.datefin = datefin;
    }

    public int getMontant() {
        return (int) montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getIdClient() {
        return id_client;
    }

    public void setIdClient(int id_client) {
        this.id_client = id_client;
    }

    public int getIdChef() {
        return id_chef;
    }

    public void setIdChef(int id_chef) {
        this.id_chef = id_chef;
    }

    @Override
    public String toString() {
        return "Projet [id_proj=" + id_proj + ", nom=" + nom + ", datedeb=" + datedeb + ", datefin=" + datefin +
                ", montant=" + montant + ", id_client=" + id_client + ", id_chef=" + id_chef + "]";
    }
}

