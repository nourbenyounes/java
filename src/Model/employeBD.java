package Model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vue.EmployeOperation;

public class employeBD {
    private TacheBD tacheBDInstance = new TacheBD();

    // Ajouter un employé à la base de données
    public void ajouterEmployeEnBase(Employe employe) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO employes (id, nom, prenom, mail, grade, id_eq) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, employe.getId());
                preparedStatement.setString(2, employe.getNom());
                preparedStatement.setString(3, employe.getPrenom());
                preparedStatement.setString(4, employe.getMail());
                preparedStatement.setString(5, employe.getGrade());
                preparedStatement.setInt(6, employe.getIdEquipe());
               //preparedStatement.setInt(7, employe.getTache().getIdTache());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
                e.printStackTrace();

        }
    }

    // Supprimer un employé de la base de données par son ID
    public void supprimerEmployeEnBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "DELETE FROM employes WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
                            e.printStackTrace();

        }
    }

    // Récupérer la liste de tous les employés depuis la base de données
    public List<Employe> getListeEmployesDepuisBase() {
        List<Employe> employes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM employes";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int employeId = resultSet.getInt("id");
                    String employeNom = resultSet.getString("nom");
                    String employePrenom = resultSet.getString("prenom");
                    String employeMail = resultSet.getString("mail");
                    String employeGrade = resultSet.getString("grade");
                    int idEquipe = resultSet.getInt("id_eq");
                    int idTache = resultSet.getInt("id_tache");

                    // Utiliser la classe Tache pour créer l'objet Tache correspondant
                    Tache employeTache = tacheBDInstance.getTacheParIdDepuisBase(idTache);

                    Employe employe = new Employe(employeId, employeNom, employePrenom, employeMail, employeGrade, employeTache, idEquipe);
                    employes.add(employe);
                }
            }
        } catch (SQLException e) {
        }
        return employes;
    }

    // Mettre à jour les informations d'un employé dans la base de données
    public void mettreAJourEmployeEnBase(Employe employe) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "UPDATE employes SET nom = ?, prenom = ?, mail = ?, grade = ?, id_eq = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, employe.getNom());
                preparedStatement.setString(2, employe.getPrenom());
                preparedStatement.setString(3, employe.getMail());
                preparedStatement.setString(4, employe.getGrade());
                preparedStatement.setInt(5, employe.getIdEquipe());
                preparedStatement.setInt(6, employe.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
                            e.printStackTrace();

        }
    }

    // Récupérer un employé par son ID depuis la base de données
    public Employe getEmployeParIdDepuisBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM employes WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String employeNom = resultSet.getString("nom");
                        String employePrenom = resultSet.getString("prenom");
                        String employeMail = resultSet.getString("mail");
                        String employeGrade = resultSet.getString("grade");
                        int idEquipe = resultSet.getInt("id_eq");
                        int idTache = resultSet.getInt("id_tache");

                        // Utiliser la classe Tache pour créer l'objet Tache correspondant
                        Tache employeTache = tacheBDInstance.getTacheParIdDepuisBase(idTache);

                        return new Employe(id, employeNom, employePrenom, employeMail, employeGrade, employeTache, idEquipe);
                    }
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }
        EmployeOperation ChangementGradeOperation = employeBD -> {
        List<Employe> employes = employeBD.getListeEmployesDepuisBase();

        for (Employe emp : employes) {
            emp.setGrade("ing");
            employeBD.mettreAJourEmployeEnBase(emp);
        }
        System.out.println("Opération de changement de grade effectuée sur la base de données.");
    };
}
