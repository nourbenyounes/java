/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import Model.Client;
import Model.clientBD;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sawss
 */
public class Ajoute_clientController implements Initializable {

    @FXML
    private Button valid;
    @FXML
    private TextField id_cl;
    @FXML
    private TextField nom_cl;
    @FXML
    private TextField prenom_cl;
    @FXML
    private TextField mail_cl;
    @FXML
    private TextField proj_cl;
    @FXML
    private TextField com_cl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
   
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        try {
                Client p = new Client(
                    Integer.parseInt(id_cl.getText()),
                    nom_cl.getText(),
                    prenom_cl.getText(),
                    mail_cl.getText(),
                    Integer.parseInt(proj_cl.getText()),
                    com_cl.getText()
                );

            clientBD tacheBD = new clientBD();

            tacheBD.ajouterClientEnBase(p);
            
            

            
            
            try {
                
                Stage st2 = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/client.fxml"));
                Parent root = loader.load();
         
                // Passer le nouveau client au contrôleur de l'interface client.fxml
                ClientController clientController = loader.getController();
                clientController.initData(p);

                Scene scene = new Scene (root);
                
                st2.setTitle("client");
                st2.setScene(scene);
                st2.show();
            } catch (IOException ex) {
                Logger.getLogger(Ajoute_clientController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);  
            }
            
            
        
        } catch (NumberFormatException | NullPointerException e) {
            // Handle parsing or null-related exceptions
            System.err.println("Error: " + e.getMessage());
        }    

    
} }
