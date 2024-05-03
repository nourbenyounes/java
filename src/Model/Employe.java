package Model;

public sealed class Employe extends Personne permits Chef {
    private String grade;
   // private int id_tache;
    private int id_eq; 
    private Tache tache;

    public Employe(int id, String nom, String prenom, String mail, String grade, Tache tache, int id_eq) {
        super(id, nom, prenom, mail);
        this.grade = grade;
        this.tache = tache;
        this.id_eq = id_eq;
    }
        public Employe(int id, String nom, String prenom, String mail, String grade, int id_eq) {
        super(id, nom, prenom, mail);
        this.grade = grade;
        this.id_eq = id_eq;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public int getIdEquipe() {
        return id_eq;
    }

    public void setIdEquipe(int id_eq) {
        this.id_eq = id_eq;
    }

    @Override
    public String toString() {
        return "Employe [id=" + getId() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", mail=" + getMail() +
                ", grade=" + grade + ", tache=" + tache + ", id_eq=" + id_eq + "]";
    }
}
