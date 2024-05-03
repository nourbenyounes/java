package Model;


public final class Chef extends Employe {
    private int id_proj; 

    public Chef(int id, String nom, String prenom, String mail, String grade, int id_eq, Tache tache, int id_proj) {
        super(id, nom, prenom, mail, grade, tache, id_eq);
        this.id_proj = id_proj;
    }

    public int getIdProjet() {
        return id_proj;
    }

    public void setIdProjet(int id_proj) {
        this.id_proj = id_proj;
    }

    @Override
    public String toString() {
        return "Chef [id=" + getId() + ", nom=" +
                getNom() + ", prenom=" + getPrenom() + ", mail=" + getMail() +
                ", grade=" + getGrade() + ", tache=" + getTache() +
                ", id_eq=" + getIdEquipe() + ", id_proj=" + id_proj + "]";
    }
}

