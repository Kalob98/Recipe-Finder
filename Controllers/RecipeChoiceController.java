package Controllers;

/**
 * This controller allows the selection of one out of six recipes.
 *
 * @author Brodrick Grimm
 *
 * Last updated 10/28/20
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brody
 */
public class RecipeChoiceController implements Initializable {

    @FXML
    private Label recipeOneLabel;
    @FXML
    private Label recipeTwoLabel;
    @FXML
    private Label recipeThreeLabel;
    @FXML
    private Label recipeFourLabel;
    @FXML
    private Label recipeFiveLabel;
    @FXML
    private Label recipeSixLabel;
    @FXML
    private Button recipeOneButton;
    @FXML
    private Button recipeTwoButton;
    @FXML
    private Button recipeThreeButton;
    @FXML
    private Button recipeFourButton;
    @FXML
    private Button recipeFiveButton;
    @FXML
    private Button recipeSixButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void RecipeOneChosen(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    @FXML
    private void back(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }
}
