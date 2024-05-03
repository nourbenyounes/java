package Model;

public sealed class Personne permits Employe, Client  {
    private int id_per;
    private String nom;
    private String prenom;
    private String mail;

    public Personne(int id, String nom, String prenom, String mail) {
        this.id_per = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public int getId() {
        return id_per;
    }

    public void setId(int id) {
        this.id_per = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    @Override
    public String toString() {
        return "Personne [id=" + id_per + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + "]";
    }
}
