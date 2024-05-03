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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.Client;
import Model.clientBD;

/**
 * FXML Controller class
 *
 * @author sawss
 */
public class Mod_clientController implements Initializable {

    @FXML
    private Button v1;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField pre;
    @FXML
    private TextField email;
    @FXML
    private TextField idp;
    @FXML
    private TextField com;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
public void initData(Client client) {
        id.setText(String.valueOf(client.getId()));
        nom.setText(client.getNom());
        pre.setText(client.getPrenom());
        email.setText(client.getMail());
        idp.setText(String.valueOf(client.getIdProjets()));
        com.setText(client.getCommentaire());
    }
    @FXML
    private void valide(ActionEvent event) {
        try {
                Client p = new Client(
                    Integer.parseInt(id.getText()),
                    nom.getText(),
                    pre.getText(),
                    email.getText(),
                    Integer.parseInt(idp.getText()),
                    com.getText()
              );

            clientBD tacheBD = new clientBD();

            tacheBD.mettreAJourClientEnBase(p);
           
        } catch (NumberFormatException | NullPointerException e) {
            // Handle parsing or null-related exceptions
            System.err.println("Error: " + e.getMessage());
        }
        
        try {
            Stage st2= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/client.fxml"));
            Scene scene = new Scene (root);

            st2.setTitle("client");
            st2.setScene(scene);
            st2.show();
        } catch (IOException ex) {
            Logger.getLogger(Ajoute_projetController.class.getName()).log(Level.SEVERE, "Erreur lors du chargement de l'interface", ex);  
        }

    }

    
}
