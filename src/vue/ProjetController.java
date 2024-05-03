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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sawss
 */
public class ProjetController implements Initializable {

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
    @FXML
    private Button aff;
    @FXML
    private TableView<Projet> tableViewProjets;

    private Projet selectedprojet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void init_Data(Projet projet) {
        selectedprojet = projet;
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdProjet()).asObject());
        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        idClientCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdClient()).asObject());

        montantCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getMontant()).asObject());

        dateDebutCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateDebut()));

        dateFinCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateFin()));
        idChefCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdChef()).asObject());

        // Créez une liste observable avec un seul élément 
        ObservableList<Projet> projettList = FXCollections.observableArrayList(selectedprojet);

        // Mettez à jour la tableViewClient avec la nouvelle liste
        tableViewProjets.setItems(projettList);
    
    }

    

    @FXML
    private void tache(ActionEvent event) {
        try {
            Stage st2= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/taches.fxml"));
            Scene scene = new Scene (root);

            st2.setTitle("tache");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);
            
        }
    }

    @FXML
    private void modifier() {
        if (selectedprojet != null) {
        try {
            // Charger l'interface de modification dans une nouvelle fenêtre
            Stage modificationStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/mod_PROJET.fxml"));
            Parent root = loader.load();

            // Passer le client sélectionné au contrôleur de l'interface de modification
            Mod_PROJETController modprojetController = loader.getController();
            modprojetController.init_Data(selectedprojet);

            Scene scene = new Scene(root);

            modificationStage.setTitle("Modifier projet");
            modificationStage.setScene(scene);
            modificationStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de modification", ex);
        }
    } else {
        System.out.println("Aucun client sélectionné pour la modification.");
    }
    }

    @FXML
    private void supprimer() {
        

    if (selectedprojet != null) {
        try {
            ProjetBD proBD = new ProjetBD();
            proBD.supprimerProjetEnBase(selectedprojet.getIdProjet());
            // Rafraîchir éventuellement la table après la suppression
           
        } catch (Exception ex) {
            Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, "Erreur lors de la suppression ", ex);
        }
    } else {
        System.out.println("Aucun projet sélectionné pour la suppression.");
    }
    }
    private Projet getSelectedProjet() {
            // Assuming that you have a method to get the selected client from the table view
            return tableViewProjets.getSelectionModel().getSelectedItem();
        }
    
}
