/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import Model.Projet;
import Model.ProjetBD;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author sawss
 */
public class Mod_PROJETController implements Initializable {

    @FXML
    private DatePicker fin;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private DatePicker debut;
    @FXML
    private TextField montant;
    @FXML
    private TextField idclt;
    @FXML
    private TextField idchef;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    void init_Data(Projet p) {
        id.setText(String.valueOf(p.getIdProjet()));
        nom.setText(p.getNom());
        debut.setValue(LocalDate.parse(p.getDateDebut()));
        fin.setValue(LocalDate.parse(p.getDateFin()));
        montant.setText(String.valueOf(p.getMontant()));
        idclt.setText(String.valueOf(p.getIdClient()));
        idchef.setText(String.valueOf(p.getIdChef()));
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            Projet p = new Projet(
                Integer.parseInt(id.getText()),
            nom.getText(),
            debut.getValue().toString(),
            fin.getValue().toString(),
            Double.parseDouble(montant.getText()),
            Integer.parseInt(idclt.getText()), // assuming idclt is the id_client TextField
            Integer.parseInt(idchef.getText())  // assuming idchef is the id_chef TextField
        );
            ProjetBD proBD = new ProjetBD();

            ProjetBD.mettreAJourProjetEnBase(p);
    
        } catch (NumberFormatException | NullPointerException e) {
            // Handle parsing or null-related exceptions
            System.err.println("Error: " + e.getMessage());
        }
    
}
}
