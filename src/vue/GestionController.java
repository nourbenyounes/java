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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sawss
 */
public class GestionController implements Initializable {

    @FXML
    private Button b1;
    @FXML
    private Button b11;
    @FXML
    private Button b111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void client(ActionEvent event1) {
        try {
            Stage st2= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/Lclients.fxml"));
            Scene scene = new Scene (root);

            st2.setTitle("liste client");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);
            
        }
    }

    @FXML
    private void emp(ActionEvent event2) {
        try {
            Stage st3= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/Lemployes.fxml"));
            Scene scene = new Scene (root);

            st3.setTitle("liste employes");
            st3.setScene(scene);
            st3.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);
             
        }
    }

    @FXML
    private void projet(ActionEvent event3) {
        try {
            Stage st4= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/Lprojets.fxml"));
            Scene scene = new Scene (root);

            st4.setTitle("liste projets");
            st4.setScene(scene);
            st4.show();
        } catch (IOException ex) {
           Logger.getLogger(GestionController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);
            
        }
    }
    
    
}
