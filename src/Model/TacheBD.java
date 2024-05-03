package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacheBD {

    public void ajouterTacheEnBase(Tache tache) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO taches (id_tache, id_projet, date_deb, date_echeance, descript, etat) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, tache.getIdTache());
                preparedStatement.setInt(2, tache.getIdProjet());
                preparedStatement.setString(3, tache.getDateDebut());
                preparedStatement.setString(4, tache.getDateEcheance());
                preparedStatement.setString(5, tache.getDescription());
                preparedStatement.setString(6, tache.getEtat());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    public void supprimerTacheEnBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "DELETE FROM taches WHERE id_tache = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    public List<Tache> getListeTachesDepuisBase() {
        List<Tache> taches = new ArrayList<>();
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM taches";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idTache = resultSet.getInt("id_tache");
                    int idProjet = resultSet.getInt("id_projet");
                    String dateDebut = resultSet.getString("date_deb");
                    String dateEcheance = resultSet.getString("date_echeance");
                    String description = resultSet.getString("descript");
                    String etat = resultSet.getString("etat");

                    Tache tache = new Tache(idTache, idProjet, dateDebut, dateEcheance, description, etat);
                    taches.add(tache);
                }
            }
        } catch (SQLException e) {
        }
        return taches;
    }

    public void mettreAJourTacheEnBase(Tache tache) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "UPDATE taches SET id_projet = ?, date_deb = ?, date_echeance = ?, descript = ?, etat = ? WHERE id_tache = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, tache.getIdProjet());
                preparedStatement.setString(2, tache.getDateDebut());
                preparedStatement.setString(3, tache.getDateEcheance());
                preparedStatement.setString(4, tache.getDescription());
                preparedStatement.setString(5, tache.getEtat());
                preparedStatement.setInt(6, tache.getIdTache());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    public Tache getTacheParIdDepuisBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM taches WHERE id_tache = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int idTache = resultSet.getInt("id_tache");
                        int idProjet = resultSet.getInt("id_projet");
                        String dateDebut = resultSet.getString("date_deb");
                        String dateEcheance = resultSet.getString("date_echeance");
                        String description = resultSet.getString("descript");
                        String etat = resultSet.getString("etat");

                        return new Tache(idTache, idProjet, dateDebut, dateEcheance, description, etat);
                    }
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
