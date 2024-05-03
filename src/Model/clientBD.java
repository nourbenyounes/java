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
public class clientBD {
    public void ajouterClientEnBase(Client client) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO clients (nom, prenom, email, id_projets, commentaire,id) VALUES (?,?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, client.getNom());
                preparedStatement.setString(2, client.getPrenom());
                preparedStatement.setString(3, client.getMail());
                preparedStatement.setInt(4, client.getIdProjets());
                preparedStatement.setString(5, client.getCommentaire());
                preparedStatement.setInt(6, client.getId());

                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    // Supprimer un client de la base de données par son ID
    public void supprimerClientEnBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "DELETE FROM clients WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    // Récupérer la liste de tous les clients depuis la base de données
    public List<Client> getListeClientsDepuisBase() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM clients";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int clientId = resultSet.getInt("id");
                    String clientNom = resultSet.getString("nom");
                    String clientPrenom = resultSet.getString("prenom");
                    String clientMail = resultSet.getString("email");
                    int idProjets = resultSet.getInt("id_projets");
                    String commentaire = resultSet.getString("commentaire");

                    Client client = new Client(clientId, clientNom, clientPrenom, clientMail, idProjets, commentaire);
                    clients.add(client);
                }
            }
            
        } catch (SQLException e) {
        }
        return clients;
    }

    // Mettre à jour les informations d'un client dans la base de données
    public void mettreAJourClientEnBase(Client client) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "UPDATE clients SET nom = ?, prenom = ?, email = ?, id_projets = ?, commentaire = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, client.getNom());
                preparedStatement.setString(2, client.getPrenom());
                preparedStatement.setString(3, client.getMail());
                preparedStatement.setInt(4, client.getIdProjets());
                preparedStatement.setString(5, client.getCommentaire());
                preparedStatement.setInt(6, client.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
        }
    }

    // Récupérer un client par son ID depuis la base de données
    public Client getClientParIdDepuisBase(int id) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM clients WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String clientNom = resultSet.getString("nom");
                        String clientPrenom = resultSet.getString("prenom");
                        String clientMail = resultSet.getString("email");
                        int idProjets = resultSet.getInt("id_projets");
                        String commentaire = resultSet.getString("commentaire");

                        return new Client(id, clientNom, clientPrenom, clientMail, idProjets, commentaire);
                    }
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }

}
