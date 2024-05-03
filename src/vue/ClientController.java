/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import Model.Client;
import Model.clientBD;

/**
 * FXML Controller class
 *
 * @author sawss
 */
public class ClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Client> tableViewClients;

    @FXML
    private TableColumn<Client, Integer> colId;
    @FXML
    private TableColumn<Client, String> colNom;
    @FXML
    private TableColumn<Client, String> colPrenom;
    @FXML
    private TableColumn<Client, String> colEmail;
    @FXML
    private TableColumn<Client, Integer> colIdProjets;
    @FXML
    private TableColumn<Client, String> colCommentaire;
    @FXML
    private Button MOD;
    @FXML
    private Button SUP;
    
    private Client selectedClient;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void initData(Client client) {
        selectedClient = client;
        // Mettez à jour les colonnes avec les informations du client
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        colPrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMail()));
        colIdProjets.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdProjets()).asObject());
        colCommentaire.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCommentaire()));

        // Créez une liste observable avec un seul élément (le client actuellement sélectionné)
        ObservableList<Client> clientList = FXCollections.observableArrayList(selectedClient);

        // Mettez à jour la tableViewClient avec la nouvelle liste
        tableViewClients.setItems(clientList);

        
    }

@FXML
private void modifier() {
    if (selectedClient != null) {
        try {
            // Charger l'interface de modification dans une nouvelle fenêtre
            Stage modificationStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/Mod_client.fxml"));
            Parent root = loader.load();

            // Passer le client sélectionné au contrôleur de l'interface de modification
            Mod_clientController modClientController = loader.getController();
            modClientController.initData(selectedClient);

            Scene scene = new Scene(root);

            modificationStage.setTitle("Modifier client");
            modificationStage.setScene(scene);
            modificationStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de modification", ex);
        }
    } else {
        System.out.println("Aucun client sélectionné pour la modification.");
    }
}



    @FXML
private void supprimer() {
    Client selectedClient = getSelectedClient();

    if (selectedClient != null) {
        try {
            clientBD cltBD = new clientBD();
            cltBD.supprimerClientEnBase(selectedClient.getId());
            // Rafraîchir éventuellement la table après la suppression
            refreshTableView();
        } catch (Exception ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, "Erreur lors de la suppression du client", ex);
        }
    } else {
        System.out.println("Aucun client sélectionné pour la suppression.");
    }
}


        private Client getSelectedClient() {
            // Assuming that you have a method to get the selected client from the table view
            return tableViewClients.getSelectionModel().getSelectedItem();
        }

        private void refreshTableView() {
            // Create an instance of clientBD
            clientBD clientDatabase = new clientBD();

            // Reload data from the database and refresh the table view
            ObservableList<Client> clients = FXCollections.observableArrayList(clientDatabase.getListeClientsDepuisBase());
            tableViewClients.setItems(clients);
        }   
}
