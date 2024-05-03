package Model;

public final class Client extends Personne {
    private int id_projets;  
    private String commentaire;

    public Client(int id, String nom, String prenom, String mail, int id_projets, String commentaire) {
        super(id, nom, prenom, mail);
        this.id_projets = id_projets;
        this.commentaire = commentaire;
    }
    

    public int getIdProjets() {
        return id_projets;
    }
    public void setIdProjets(int id_projets) {
        this.id_projets = id_projets;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Client [id=" + getId() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", mail=" + getMail() +
                ", id_projets=" + id_projets + ", commentaire=" + commentaire + "]";
    }
}

