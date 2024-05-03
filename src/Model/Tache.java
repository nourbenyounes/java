package Model;
public class Tache {
    private int id_tache;  
    private int id_projet;  
    private String date_deb;  
    private String date_echeance; 
    private String description;  
    private String etat;  
    public Tache(int id_tache, int id_projet, String date_deb,
            String date_echeance,String description, String etat) {
        this.id_tache = id_tache;
        this.id_projet = id_projet;
        this.date_deb = date_deb;
        this.date_echeance = date_echeance;
        this.description = description;
        this.etat = etat;
    }
    public int getIdTache() {
        return id_tache;
    }
    public void setIdTache(int id_tache) {
        this.id_tache = id_tache;
    }
    public int getIdProjet() {
        return id_projet;
    }
    public void setIdProjet(int id_projet) {
        this.id_projet = id_projet;
    }
    public String getDateDebut() {
        return date_deb;
    }
    public void setDateDebut(String date_deb) {
        this.date_deb = date_deb;
    }
    public String getDateEcheance() {
        return date_echeance;
    }
    public void setDateEcheance(String date_echeance) {
        this.date_echeance = date_echeance;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    @Override
    public String toString() {
        return "Tache [id_tache=" + id_tache + ", id_projet=" 
                + id_projet + ", date_deb=" + date_deb +
                ", date_echeance=" + date_echeance + ", description=" 
                + description + ", etat=" + etat + "]";
    }
}



