/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetjava.ProjetJava;


/**
 * FXML Controller class
 *
 * @author sawss
 */
public class LoginController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button b;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickon(ActionEvent event) {
        try {
            Stage st= new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/vue/gestion.fxml"));
            Scene scene = new Scene (root);

            st.setTitle("DEUXEME");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
           Logger.getLogger(ProjetJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);        
        }
    }
    
}
