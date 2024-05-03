/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nour2
 */
public class ProjetBD {
  
    // Ajouter un projet à la base de données
    public static void ajouterProjetEnBase(Projet projet) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO projets (id_projet, nom_projet, date_debut, date_fin, budget, id_client, id_equipe) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, projet.getIdProjet());
                preparedStatement.setString(2, projet.getNom());
                preparedStatement.setString(3, projet.getDateDebut());
                preparedStatement.setString(4, projet.getDateFin());
                preparedStatement.setDouble(5, projet.getMontant());
                preparedStatement.setInt(6, projet.getIdClient());
                preparedStatement.setInt(7, projet.getIdChef());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            
        }
    }

    // Mettre à jour un projet dans la base de données
    public static void mettreAJourProjetEnBase(Projet projet) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "UPDATE projets SET nom = ?, date_debut = ?, date_fin = ?, budget = ?, id_client = ?, id_equipe = ? WHERE id_projet = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, projet.getNom());
                preparedStatement.setString(2, projet.getDateDebut());
                preparedStatement.setString(3, projet.getDateFin());
                preparedStatement.setDouble(4, projet.getMontant());
                preparedStatement.setInt(5, projet.getIdClient());
                preparedStatement.setInt(6, projet.getIdChef());
                preparedStatement.setInt(7, projet.getIdProjet());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    // Supprimer un projet de la base de données par son ID
    public static void supprimerProjetEnBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "DELETE FROM projets WHERE id_projet = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    // Récupérer un projet par son ID depuis la base de données
    public static Projet getProjetParIdDepuisBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM projets WHERE id_projet = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String nom = resultSet.getString("nom");
                        String dateDebut = resultSet.getString("date_debut");
                        String dateFin = resultSet.getString("date_fin");
                        double montant = resultSet.getDouble("budget");
                        int idClient = resultSet.getInt("id_client");
                        int idChef = resultSet.getInt("id_equipe");

                        return new Projet(id, nom, dateDebut, dateFin, montant, idClient, idChef);
                    }
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }

    // Récupérer la liste de tous les projets depuis la base de données
    public static List<Projet> getListeProjetsDepuisBase() {
        List<Projet> projets = new ArrayList<>();
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM projets";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idProj = resultSet.getInt("id_projet");
                    String nom = resultSet.getString("nom_projet");
                    String dateDebut = resultSet.getString("date_debut");
                    String dateFin = resultSet.getString("date_fin");
                    double montant = resultSet.getDouble("budget");
                    int idClient = resultSet.getInt("id_client");
                    int idChef = resultSet.getInt("id_equipe");

                    Projet projet = new Projet(idProj, nom, dateDebut, dateFin, montant, idClient, idChef);
                    projets.add(projet);
                }
            }
        } catch (SQLException e) {
        }
        return projets;
    }
}
  

