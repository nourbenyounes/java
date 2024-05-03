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
public class Ajoute_employeController implements Initializable {

    @FXML
    private ChoiceBox<?> eq_emp;
    @FXML
    private TextField id_emp;
    @FXML
    private TextField nom_emp;
    @FXML
    private DatePicker naiss_emp;
    @FXML
    private TextField prenom_emp;
    @FXML
    private TextField mail_emp;
    @FXML
    private Button V;
    @FXML
    private TextField grade_emp;

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
            Employe p = new Employe(
                Integer.parseInt(id_emp.getText()),
                nom_emp.getText(),
                prenom_emp.getText(),
                mail_emp.getText(),
                grade_emp.getText(),
                //Integer.parseInt((String) eq_emp.getValue())
                    1
            );
            employeBD tacheBD = new employeBD();
            tacheBD.ajouterEmployeEnBase(p);

            // Use add method of HashSet, it automatically handles duplicates
            
            
        } catch (NumberFormatException | NullPointerException e) {
            // Handle parsing or null-related exceptions
            System.err.println("Error: " + e.getMessage());
        }
       
    }
    
}
