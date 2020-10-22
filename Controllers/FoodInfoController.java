package Controllers;

/**
 * This controller lets you choose a cuisine and items to include and/or
 * exclude, or the app will find a random recipe for you.
 *
 * @author Brody
 * @author Kalob Reinholz
 *
 * Last updated 10/20/20
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import APIs.Cuisines;
import APIs.Ingredients;
import javafx.scene.control.ComboBox;

public class FoodInfoController implements Initializable {

    @FXML
    private ChoiceBox<String> cuisineChoiceBox;
    @FXML
    private ComboBox<String> includedItemsComboBox;
    @FXML
    private ComboBox<String> excludedItemsComboBox;
    @FXML
    private Button randomButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    @FXML
    private void randomButton(ActionEvent _event) throws IOException {
        Parent infoParent1 = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene1 = new Scene(infoParent1);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene1);
        window.show();
    }

    @FXML
    private void back(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    @FXML
    private void searchButton(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeScene.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    private void loadData() {
        cuisineChoiceBox.getItems().addAll(Cuisines.loadCuisines());
        
        //this causes the program to have an error and not go to the FoodInfoScene
        //includedItemsComboBox.getItems().addAll(Ingredients.loadIngredients());
        //excludedItemsComboBox.getItems().addAll(Ingredients.loadIngredients());
    }

}
