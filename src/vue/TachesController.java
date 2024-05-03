/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sawss
 */
public class TachesController implements Initializable {

    @FXML
    private Button aj;
    @FXML
    private TableView<?> tab_tache;
    @FXML
    private TableColumn<?, ?> idtache;
    @FXML
    private TableColumn<?, ?> idpro;
    @FXML
    private TableColumn<?, ?> datedeb;
    @FXML
    private TableColumn<?, ?> dateech;
    @FXML
    private TableColumn<?, ?> diis;
    @FXML
    private TableColumn<?, ?> etattacghe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajout(ActionEvent event) {
    }

    @FXML
    private void modif(MouseEvent event) {
    }
    
}
