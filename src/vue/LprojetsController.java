/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;


import Model.Projet;
import Model.ProjetBD;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sawss
 */
public class LprojetsController implements Initializable {
    
    @FXML
    private Button AP ;
    @FXML
    private TableView<Projet> tableViewProjets;
    @FXML
    private TableColumn<Projet, Integer> colId;
    @FXML
    private TableColumn<Projet, String> colNom;
    @FXML
    private TableColumn<Projet, String> dateDebutCol;
    @FXML
    private TableColumn<Projet, String> dateFinCol;
    @FXML
    private TableColumn<Projet, Integer> montantCol;
    @FXML
    private TableColumn<Projet, Integer> idClientCol;
    @FXML
    private TableColumn<Projet, Integer> idChefCol;

    private ProjetBD projetBD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        projetBD = new ProjetBD();
        initializeTableView();
        
        tableViewProjets.setOnMouseClicked(event -> {
        if (event.getClickCount() == 1) { // Check for single click
            afficher();
        }
    });
    }  
    
    
        private void initializeTableView() {
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdProjet()).asObject());
        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        idClientCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdClient()).asObject());

        montantCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getMontant()).asObject());

        dateDebutCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateDebut()));

        dateFinCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateFin()));
        idChefCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdChef()).asObject());

        // Charger les données depuis la base de données
        ObservableList<Projet> projets = FXCollections.observableArrayList(ProjetBD.getListeProjetsDepuisBase());
        tableViewProjets.setItems(projets);
    }

    @FXML
    private void Ajoutprojet(ActionEvent event) {
        try {
            Stage st2= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/Ajoute_projet.fxml"));
            Scene scene = new Scene (root);

            st2.setTitle("projet");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(LprojetsController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);
            
        }
    }

    private void afficher() {
        
        Projet selectedprojet = tableViewProjets.getSelectionModel().getSelectedItem();

        if (selectedprojet != null) {
            try {
                // Load the modification interface in a new stage
                Stage modificationStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/projet.fxml"));
                Parent root = loader.load();

                // Pass the selected client to the controller of the modification interface
                ProjetController projetController = loader.getController();
                projetController.init_Data(selectedprojet);


                Scene scene = new Scene(root);

                modificationStage.setTitle("afficher projet");
                modificationStage.setScene(scene);
                modificationStage.show();
            } catch (IOException ex) {
                Logger.getLogger(LclientsController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de l'affichage", ex);
            }
        } else {
            // Inform the user that no client is selected for modification
            System.out.println("Aucun projet sélectionné pour l'affichache.");
        }
    }

    
}
