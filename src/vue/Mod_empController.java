package vue;

import Model.Employe;
import Model.employeBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class Mod_empController implements Initializable {

    @FXML
    private ChoiceBox<String> grade;
    @FXML
    private ChoiceBox<Integer> eq;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adr; // Ajoutez le champ adr s'il est défini dans votre classe Employe
    @FXML
    private TextField mail;
    @FXML
    private TextField tache;
    @FXML
    private Button valide;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisations supplémentaires si nécessaire
    }

    public void initData(Employe employe) {
        id.setText(String.valueOf(employe.getId()));
        nom.setText(employe.getNom());
        prenom.setText(employe.getPrenom());
        mail.setText(employe.getMail());
        // Assurez-vous que vos champs grade, eq, tache, adr sont correctement initialisés
        grade.setValue(employe.getGrade());
        eq.setValue(employe.getIdEquipe());
        tache.setText(String.valueOf(employe.getTache().getIdTache()));
        // Adresse (adr) si définie dans la classe Employe
        // adr.setText(employe.getAdresse());
    }

    @FXML
    private void valide(ActionEvent event) {
        try {
            Employe p = new Employe(
                    Integer.parseInt(id.getText()),
                    nom.getText(),
                    prenom.getText(),
                    mail.getText(),
                    grade.getValue(),
                    // Assurez-vous de gérer correctement le type de données pour eq et tache
                    eq.getValue()
                    // Adresse (adr) si définie dans la classe Employe
                    // adr.getText()
            );
            

            employeBD tacheBD = new employeBD();

            tacheBD.mettreAJourEmployeEnBase(p);
        } catch (NumberFormatException | NullPointerException e) {
            // Gérez les exceptions liées à la conversion de types ou aux valeurs nulles
            System.err.println("Error: " + e.getMessage());
        }
    }
}
