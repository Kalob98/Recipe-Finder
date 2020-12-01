package Controllers;

/**
 * This controller is the first scene. This is where you can learn how to use
 * the app, look at saved recipes, and start to find a recipe.
 *
 * @author Brodrick Grimm
 * @author Kalob Reinholz
 * @author Heng Tan
 *
 * Last updated 11/30/20
 */
import Models.RecipeArray;
import Models.SavedRecipesRead;
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
    }

    /**
     * Goes to the RecipeChoice scene to display all saved recipes.
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void prevRecipe(ActionEvent _event) throws IOException {

        //copys the instance variables from all targeted recipes
        RecipeArray temp = RecipeArray.getInstance();
        temp.setRecipes(SavedRecipesRead.getSavedRecipes());

        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/RecipeChoice.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    /**
     * Goes to the HowToUse view
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void howToUse(ActionEvent _event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Views/HowToUse.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene);
        window.show();
    }

    /**
     * Goes to the FoodInfo view
     *
     * @param _event
     * @throws IOException
     */
    @FXML
    private void next(ActionEvent _event) throws IOException {
        Parent infoParnet = FXMLLoader.load(getClass().getResource("/Views/FoodInfo.fxml"));
        Scene infoScene1 = new Scene(infoParnet);

        Stage window = (Stage) ((Node) _event.getSource()).getScene().getWindow();

        window.setScene(infoScene1);
        window.show();
    }

    /**
     * Closes the program.
     *
     * @param _event
     */
    @FXML
    private void quit(ActionEvent _event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
