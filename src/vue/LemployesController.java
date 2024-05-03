/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import Model.Employe;
import Model.employeBD;
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
import Model.Client;

/**
 * FXML Controller class
 *
 * @author sawss
 */
public class LemployesController implements Initializable {

    @FXML
    private Button AE;
    @FXML
    private TableView<Employe> tableViewEmployes;

    @FXML
    private TableColumn<Employe, Integer> colId;
    @FXML
    private TableColumn<Employe, String> colNom;
    @FXML
    private TableColumn<Employe, String> colPrenom;
    @FXML
    private TableColumn<Employe, String> colEmail;
    @FXML
    private TableColumn<Employe, String> colgrade;
    @FXML
    private TableColumn<Employe, Integer> colIdeq;
    private employeBD employeBD;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeBD = new employeBD();
        initializeTableView();  
        
        // Add a mouse click event handler to the TableView
        tableViewEmployes.setOnMouseClicked(event -> {
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
        //colIdProjets.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdProjets()).asObject());
        colgrade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGrade()));
        colIdeq.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdEquipe()).asObject());

        // Charger les données depuis la base de données
        ObservableList<Employe> empl = FXCollections.observableArrayList(employeBD.getListeEmployesDepuisBase());
        tableViewEmployes.setItems(empl);
    }


    @FXML
    private void Ajoutemp(ActionEvent event) {
        try {
            Stage st2= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/Ajoute_employe.fxml"));
            Scene scene = new Scene (root);

            st2.setTitle("client");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(LemployesController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);
            
        }
    }
/*
    private void modifier() {
        Employe selectedEmploye = tableViewEmployes.getSelectionModel().getSelectedItem();

        if (selectedEmploye != null) {
            try {
                // Load the modification interface in a new stage
                Stage modificationStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/mod_emp.fxml"));
                Parent root = loader.load();

                // Pass the selected client to the controller of the modification interface


                Scene scene = new Scene(root);

                modificationStage.setTitle("Modifier Employe");
                modificationStage.setScene(scene);
                modificationStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Mod_empController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de modification", ex);
            }
        } else {
            // Inform the user that no client is selected for modification
            System.out.println("Aucun Employe sélectionné pour la modification.");
        }
    }
*/
    @FXML
    private void afficher() {
        Employe selectedempl = tableViewEmployes.getSelectionModel().getSelectedItem();

        if (selectedempl != null) {
            try {
                // Load the modification interface in a new stage
                Stage aStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/employe.fxml"));
                Parent root = loader.load();

                // Pass the selected client to the controller of the modification interface
                EmployeController empController = loader.getController();
                empController.initData(selectedempl);


                Scene scene = new Scene(root);

                aStage.setTitle("afficher employe");
                aStage.setScene(scene);
                aStage.show();
            } catch (IOException ex) {
                Logger.getLogger(LemployesController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de l'affichage", ex);
            }
        } else {
            // Inform the user that no client is selected for modification
            System.out.println("Aucun emp sélectionné pour l'affichache.");
        }
    }
    
}
