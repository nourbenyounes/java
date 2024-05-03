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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import Model.Employe;
import Model.Tache;
import Model.clientBD;
import Model.employeBD;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Nour2
 */
public class EmployeController implements Initializable {

    @FXML
    private TableColumn<Employe, Integer> colId;
    @FXML
    private TableColumn<Employe, String> colNom;
    @FXML
    private TableColumn<Employe, String> colPrenom;
    @FXML
    private TableColumn<Employe, String> colEmail;
    @FXML
    private TableColumn<Employe, String> grade;
    @FXML
    private TableColumn<Employe, Tache > tache;
    @FXML
    private TableColumn<Employe, Integer> ideq;
    @FXML
    private Button mod;
    
    private Employe selectedEmploye;
    @FXML
    private TableView<Employe> tableViewEmployes;
    @FXML
    private Button supp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void initData(Employe employe) {
        selectedEmploye = employe ;
        colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        colPrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMail()));
        //colIdProjets.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdProjets()).asObject());
        grade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGrade()));
        ideq.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdEquipe()).asObject());

        // Charger les données depuis la base de données
        ObservableList<Employe> empliste = FXCollections.observableArrayList(selectedEmploye);
        
        tableViewEmployes.setItems(empliste);
        
    }
            private Employe getSelectedEmploye() {
            // Assuming that you have a method to get the selected client from the table view
            return tableViewEmployes.getSelectionModel().getSelectedItem();
        }


    @FXML
private void modifier(ActionEvent event) {
    Employe selectedEmploye = tableViewEmployes.getSelectionModel().getSelectedItem();
    if (selectedEmploye != null) {
        try {
            Stage modificationStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/Mod_emp.fxml"));
            Parent root = loader.load();

            Mod_empController modEmployeController = loader.getController();
            modEmployeController.initData(selectedEmploye);

            Scene scene = new Scene(root);

            modificationStage.setTitle("Modifier Employé");
            modificationStage.setScene(scene);
            modificationStage.show();
        } catch (IOException ex) {
            Logger.getLogger(LemployesController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface de modification", ex);
        }
    } else {
        System.out.println("Aucun employé sélectionné pour la modification.");
    }
}

@FXML
private void supprimer(ActionEvent event) {
    Employe selectedEmploye = tableViewEmployes.getSelectionModel().getSelectedItem();
    if (selectedEmploye != null) {
        try {
            employeBD empBD = new employeBD();
            empBD.supprimerEmployeEnBase(selectedEmploye.getId());
            // Rafraîchir éventuellement la table après la suppression
            refreshTableView();
        } catch (Exception ex) {
            Logger.getLogger(LemployesController.class.getName()).log(Level.SEVERE, "Erreur lors de la suppression de l'employé", ex);
        }
    } else {
        System.out.println("Aucun employé sélectionné pour la suppression.");
    }
}
        private void refreshTableView() {
            // Create an instance of clientBD
            employeBD clientDatabase = new employeBD();

            // Reload data from the database and refresh the table view
            ObservableList<Employe> clients = FXCollections.observableArrayList(clientDatabase.getListeEmployesDepuisBase());
            tableViewEmployes.setItems(clients);
        } 



}
    

