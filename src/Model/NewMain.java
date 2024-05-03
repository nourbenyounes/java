package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
package entreprise;



import manipBD.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMain {
    // Exemple d'utilisation de la connexion à la base de données
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.connect()) {
            // Exemple : sélectionnez tous les clients de la table "clients"
            String query = "SELECT * FROM clients";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Traitez les résultats
                while (resultSet.next()) {
                    int clientId = resultSet.getInt("id");
                    String clientNom = resultSet.getString("nom");
                    String clientPrenom = resultSet.getString("prenom");

                    System.out.println("ID : " + clientId + ", Nom : " + clientNom + ", Prénom : " + clientPrenom);
                }
            }
        } catch (SQLException e) {
        }
    }
}
   */

