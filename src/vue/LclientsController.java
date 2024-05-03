package vue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

public class LclientsController implements Initializable {

    @FXML
    private Button Aclt;
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

    private clientBD clientBD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientBD = new clientBD();
        initializeTableView();
        
        // Add a mouse click event handler to the TableView
        tableViewClients.setOnMouseClicked(event -> {
        if (event.getClickCount() == 1) { // Check for single click
            afficher();
        }
    });
    }

    private void initializeTableView() {
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        colPrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMail()));
        colIdProjets.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdProjets()).asObject());
        colCommentaire.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCommentaire()));
        
// Charger les données depuis la base de données
        ObservableList<Client> clients = FXCollections.observableArrayList(clientBD.getListeClientsDepuisBase());
        tableViewClients.setItems(clients);
    }

    @FXML
    private void Ajoutclt(javafx.event.ActionEvent event) {
        try {
            Stage st2 = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/Ajoute_client.fxml"));
            Scene scene = new Scene(root);

            st2.setTitle("client");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(LclientsController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);

        }
    }


    @FXML
    

    private void afficher() {
        Client selectedClient = tableViewClients.getSelectionModel().getSelectedItem();

        if (selectedClient != null) {
            try {
                // Load the modification interface in a new stage
                Stage modificationStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/client.fxml"));
                Parent root = loader.load();

                // Pass the selected client to the controller of the modification interface
                ClientController clientController = loader.getController();
                clientController.initData(selectedClient);


                Scene scene = new Scene(root);

                modificationStage.setTitle("afficher client");
                modificationStage.setScene(scene);
                modificationStage.show();
            } catch (IOException ex) {
                Logger.getLogger(LclientsController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de l'affichage", ex);
            }
        } else {
            // Inform the user that no client is selected for modification
            System.out.println("Aucun client sélectionné pour l'affichache.");
        }
    }
    private void refreshTableView() {
    ObservableList<Client> clients = FXCollections.observableArrayList(clientBD.getListeClientsDepuisBase());
    tableViewClients.setItems(clients);
}

}