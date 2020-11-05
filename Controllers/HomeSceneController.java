package Controllers;

/**
 * This controller is the first scene. This is where you can learn how to use
 * the app, look at saved recipes, and start to find a recipe.
 *
 * @author Brody
 * @author Kalob Reinholz
 *
 * Last updated 10/28/20
 */
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
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class HomeSceneController implements Initializable {

    @FXML
    private Button prevRecipe;
    @FXML
    private Button howToUse;
    @FXML
    private Button next;
    @FXML
    private Button quitButton;

    /**
     * Initializes the controller class.
     *
     * @param _url
     * @param _rb
     */
    @Override
    public void initialize(URL _url, ResourceBundle _rb) {
        // TODO
    }

    @FXML
    private void prevRecipe(ActionEvent _event) throws IOException {
    }

    @FXML
    private void howToUse(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HowToUse.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    @FXML
    private void next(ActionEvent _event) throws IOException {
        Parent infoParnet = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene1 = new Scene(infoParnet);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene1);
        window.show();
    }

    @FXML
    private void quit(ActionEvent _event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
