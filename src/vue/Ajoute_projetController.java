/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import Model.Projet;
import Model.ProjetBD;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sawss
 */
public class Ajoute_projetController implements Initializable {

    @FXML
    private DatePicker fin_proj;
    @FXML
    private ChoiceBox<?> cl_proj;
    @FXML
    private TextField id_proj;
    @FXML
    private TextField nom_proj;
    @FXML
    private DatePicker deb_proj;
    @FXML
    private TextField montant_proj;
    @FXML
    private ChoiceBox<?> chef_proj;
    @FXML
    private Button valid;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {

        
        try {
            Projet p = new Projet(
                Integer.parseInt(id_proj.getText()),
                nom_proj.getText(),
                deb_proj.getValue().toString(),
                fin_proj.getValue().toString(),
                Double.parseDouble(montant_proj.getText()),
                1,
                1
                //Integer.parseInt((String) cl_proj.getValue()),
                //Integer.parseInt((String) chef_proj.getValue())
            );

            ProjetBD.ajouterProjetEnBase(p);
                    
           try {
            Stage st2= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/projet.fxml"));
            Scene scene = new Scene (root);

            st2.setTitle("client");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajoute_projetController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);  
        }

            // Use add method of HashSet, it automatically handles duplicates

            // Use add method of HashSet, it automatically handles duplicates
        } catch (NumberFormatException | NullPointerException e) {
            // Handle parsing or null-related exceptions
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
/**/