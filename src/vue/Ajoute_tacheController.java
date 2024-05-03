/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import Model.Tache;
import Model.TacheBD;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sawss
 */
public class Ajoute_tacheController implements Initializable {

    @FXML
    private DatePicker fin_tache;
    @FXML
    private TextField id_tache;
    @FXML
    private TextField proj_tache;
    @FXML
    private DatePicker deb_tache;
    @FXML
    private TextField desc_tache;
    @FXML
    private Button valid;
    @FXML
    private TextField etat_tache;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Tache p = new Tache(
                Integer.parseInt(id_tache.getText()),
                Integer.parseInt(proj_tache.getText()),

                deb_tache.getValue().toString(),
                fin_tache.getValue().toString(),
                desc_tache.getText(),
                etat_tache.getText()

            );
            // Use add method of HashSet, it automatically handles duplicates
            TacheBD tacheBD = new TacheBD();
            tacheBD.ajouterTacheEnBase(p);
        } catch (NumberFormatException | NullPointerException e) {
            // Handle parsing or null-related exceptions
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
